class Solution {
    public int minLength(int[] nums, int k) {
        // Frequency array kyunki nums[i] <= 100000 hai. 
        // HashSet se fast hota hai.
        int[] freq = new int[100001]; 
        long currentSum = 0; // Use long for safety
        int ans = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;

        while (j < nums.length) {
            // Expansion: Element ko window mein add karo
            if (freq[nums[j]] == 0) {
                // Agar count 0 tha, matlab ye distinct value hai -> Sum mein add karo
                currentSum += nums[j];
            }
            freq[nums[j]]++;

            // Contraction: Jab tak condition meet ho rahi hai, window choti karo
            while (currentSum >= k) {
                ans = Math.min(ans, j - i + 1);
                
                // Element ko remove karo
                freq[nums[i]]--;
                if (freq[nums[i]] == 0) {
                    // Agar count 0 ho gya, tabhi sum se ghatao
                    currentSum -= nums[i];
                }
                i++;
            }
            j++;
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}