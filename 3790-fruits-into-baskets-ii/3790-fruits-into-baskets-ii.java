class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length;
        boolean[] basketsUsed = new boolean[n];
        int unplacedCount = 0;

        for (int fruitQuantity : fruits) {
            boolean isPlaced = false;
            for (int j = 0; j < n; j++) {
                if (!basketsUsed[j] && baskets[j] >= fruitQuantity) {
                    basketsUsed[j] = true;
                    isPlaced = true;
                    break;
                }
            }

            if (!isPlaced) {
                unplacedCount++;
            }
        }

        return unplacedCount;
    }
}
