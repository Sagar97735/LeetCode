class Solution {
    public boolean canDistribute(int[] nums, int[] quantity) {
        // Step 1: Count frequencies of each number
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Store only the frequencies (we don’t care about the actual numbers)
        List<Integer> freqList = new ArrayList<>(freqMap.values());

        // Step 3: Sort quantity in descending order (to match large demands first)
        Arrays.sort(quantity);
        reverse(quantity);

        // Step 4: Backtrack to assign quantities
        return backtrack(0, quantity, freqList);
    }

    private boolean backtrack(int index, int[] quantity, List<Integer> freqList) {
        if (index == quantity.length) return true; // All customers satisfied

        for (int i = 0; i < freqList.size(); i++) {
            if (freqList.get(i) >= quantity[index]) {
                // Assign quantity[index] to this frequency
                freqList.set(i, freqList.get(i) - quantity[index]);

                if (backtrack(index + 1, quantity, freqList)) return true;

                // Backtrack
                freqList.set(i, freqList.get(i) + quantity[index]);
            }
        }

        return false; // Could not satisfy current customer
    }

    private void reverse(int[] arr) {
        int l = 0, r = arr.length - 1;
        while (l < r) {
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
    }
}
