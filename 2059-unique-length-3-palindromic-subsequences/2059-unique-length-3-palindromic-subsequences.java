class Solution {
    public int countPalindromicSubsequence(String s) {
        int ans = 0;
        
        // Iterate through all 26 possible outer characters ('a' through 'z')
        for (int i = 0; i < 26; i++) {
            char c = (char) ('a' + i);
            
            // 1. Find the first occurrence (L)
            int L = -1;
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == c) {
                    L = j;
                    break; // Found the first one
                }
            }
            
            // 2. Find the last occurrence (R)
            int R = -1;
            for (int j = s.length() - 1; j >= 0; j--) {
                if (s.charAt(j) == c) {
                    R = j;
                    break; // Found the last one
                }
            }
            
            // 3. Check if the character appears at least twice (L < R)
            if (L < R) {
                // The palindromes are of the form 'c x c', where x is any character 
                // between index L and index R (exclusive).
                
                // Use a boolean array to track the unique middle characters found
                boolean[] middleChars = new boolean[26];
                int uniqueMiddleCount = 0;
                
                // 4. Iterate through the substring s[L+1...R-1]
                for (int j = L + 1; j < R; j++) {
                    int charIndex = s.charAt(j) - 'a';
                    if (!middleChars[charIndex]) {
                        middleChars[charIndex] = true;
                        uniqueMiddleCount++;
                    }
                }
                
                // 5. Add the number of unique middle characters to the total answer
                ans += uniqueMiddleCount;
            }
        }
        
        return ans;
    }
}