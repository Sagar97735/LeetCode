import java.util.*;

class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        Map<Integer, Integer> freq = new TreeMap<>();

        // Step 1: Count frequency differences
        for (int val : basket1) {
            freq.put(val, freq.getOrDefault(val, 0) + 1);
        }
        for (int val : basket2) {
            freq.put(val, freq.getOrDefault(val, 0) - 1);
        }

        List<Integer> extraFromBasket1 = new ArrayList<>();
        List<Integer> extraFromBasket2 = new ArrayList<>();

        // Step 2: Check validity and collect extra fruits
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            int fruit = entry.getKey();
            int diff = entry.getValue();

            if (diff % 2 != 0) return -1; // Not possible to balance

            int times = Math.abs(diff) / 2;
            if (diff > 0) {
                for (int i = 0; i < times; i++) {
                    extraFromBasket1.add(fruit); // Extra in basket1
                }
            } else if (diff < 0) {
                for (int i = 0; i < times; i++) {
                    extraFromBasket2.add(fruit); // Extra in basket2
                }
            }
        }

        if (extraFromBasket1.size() == 0) return 0; // Already equal

        // Step 3: Sort for pairing
        Collections.sort(extraFromBasket1);
        Collections.sort(extraFromBasket2, Collections.reverseOrder());

        // Step 4: Find the cheapest fruit in both baskets
        int minFruit = Integer.MAX_VALUE;
        for (int val : basket1) minFruit = Math.min(minFruit, val);
        for (int val : basket2) minFruit = Math.min(minFruit, val);

        // Step 5: Swap cost calculation
        long cost = 0;
        for (int i = 0; i < extraFromBasket1.size(); i++) {
            int a = extraFromBasket1.get(i);
            int b = extraFromBasket2.get(i);
            cost += Math.min(Math.min(a, b), 2 * minFruit);
        }

        return cost;
    }
}
