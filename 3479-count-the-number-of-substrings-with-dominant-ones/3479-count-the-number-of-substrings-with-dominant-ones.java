import java.util.ArrayList;
import java.util.List;

class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int ans = 0;

        // Store indices of all zeros
        List<Integer> zeroIndices = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                zeroIndices.add(i);
            }
        }

        // --- 1. Count substrings with zeros = 0 ---
        // (Substrings of all '1's)
        int onesCount = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                onesCount++;
            } else {
                // A block of '1's just ended. Add all its substrings.
                ans += (long)onesCount * (onesCount + 1) / 2;
                onesCount = 0; // Reset
            }
        }
        // Add the last block if the string ends with '1'
        ans += (long)onesCount * (onesCount + 1) / 2;

        // --- 2. Count substrings with zeros >= 1 ---
        int zSize = zeroIndices.size();
        
        // **THE FIX IS HERE**
        // This pointer is an index into zeroIndices.
        // We maintain it *outside* the loop.
        int firstZeroPtr = 0; 
        
        // 'i' is the starting index of the substring
        for (int i = 0; i < n; i++) { // O(N) outer loop
            
            // **THE FIX**
            // Instead of a new inner loop, we just slide the pointer forward.
            // This 'while' loop will only run N times *in total* across
            // the *entire* 'for' loop, not N times *per* 'for' loop.
            while (firstZeroPtr < zSize && zeroIndices.get(firstZeroPtr) < i) {
                firstZeroPtr++;
            }
            
            if (firstZeroPtr == zSize) {
                // No more zeros at or after index 'i', so we can stop.
                break;
            }

            // This inner loop is O(sqrt(N))
            for (int k = 1; k * k <= n; k++) {
                // This is the index in zeroIndices for the k-th zero
                int currentZeroListIdx = firstZeroPtr + k - 1;

                if (currentZeroListIdx >= zSize) {
                    // This substring starting at 'i' doesn't have k zeros
                    break;
                }

                // j_k: The index *in the string s* of the k-th zero
                int j_k = zeroIndices.get(currentZeroListIdx);

                // j_next_zero: The index of the (k+1)-th zero (or n if no more zeros)
                int j_next_zero = (currentZeroListIdx + 1 < zSize) ? 
                                   zeroIndices.get(currentZeroListIdx + 1) : n;

                // We need ones >= k*k
                // (j - i + 1) - k >= k*k
                // j >= k*k + k + i - 1
                int min_j = (k * k) + k + i - 1;

                // Count j's in the valid range [j_k, j_next_zero - 1]
                // that also satisfy j >= min_j
                
                int start_j = Math.max(j_k, min_j);
                int end_j = j_next_zero - 1;

                ans += Math.max(0, end_j - start_j + 1);
            }
        }

        return ans;
    }
}