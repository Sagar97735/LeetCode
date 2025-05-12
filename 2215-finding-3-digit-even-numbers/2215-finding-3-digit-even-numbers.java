class Solution {
    public int[] findEvenNumbers(int[] digits) {
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < digits.length; i++) {
            if (digits[i] == 0) continue; // First digit can't be zero
            for (int j = 0; j < digits.length; j++) {
                if (j == i) continue;
                for (int k = 0; k < digits.length; k++) {
                    if (k == i || k == j) continue;

                    int num = digits[i] * 100 + digits[j] * 10 + digits[k];
                    if (num % 2 == 0) {
                        set.add(num);
                    }
                }
            }
        }

        int[] result = new int[set.size()];
        int index = 0;
        for (int val : set) {
            result[index++] = val;
        }

        Arrays.sort(result);
        return result;
    }
}
