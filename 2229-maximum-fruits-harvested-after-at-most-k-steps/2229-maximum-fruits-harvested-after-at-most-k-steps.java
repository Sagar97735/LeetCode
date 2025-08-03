class Solution {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int n = fruits.length;
        int maxFruits = 0, currFruits = 0;
        int left = 0;

        for (int right = 0; right < n; right++) {
            currFruits += fruits[right][1]; // add fruits at right

            // Shrink window from left if steps > k
            while (left <= right && isTooFar(fruits[left][0], fruits[right][0], startPos, k)) {
                currFruits -= fruits[left][1]; // remove fruits at left
                left++;
            }

            maxFruits = Math.max(maxFruits, currFruits);
        }

        return maxFruits;
    }

    private boolean isTooFar(int leftPos, int rightPos, int startPos, int k) {
        int toLeftFirst = Math.abs(startPos - leftPos) + (rightPos - leftPos);
        int toRightFirst = Math.abs(startPos - rightPos) + (rightPos - leftPos);
        return Math.min(toLeftFirst, toRightFirst) > k;
    }
}
