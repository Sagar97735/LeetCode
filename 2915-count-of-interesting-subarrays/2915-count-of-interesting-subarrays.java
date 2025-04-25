class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        long ans = 0;
        int count = 0;
        Map<Integer, Integer> prefixMap = new HashMap<>();
        prefixMap.put(0, 1); // Initialize with count 0 seen once

        for (int num : nums) {
            if (num % modulo == k) {
                count++;
            }

            int mod = count % modulo;
            // Calculate the target: (mod - k + modulo) % modulo to handle negative values
            int target = (mod - k + modulo) % modulo;

            ans += prefixMap.getOrDefault(target, 0);
            prefixMap.put(mod, prefixMap.getOrDefault(mod, 0) + 1);
        }

        return ans;
    }
}
