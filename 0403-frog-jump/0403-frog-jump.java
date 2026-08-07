import java.util.*;

class Solution {

    public boolean solve(int[] stones, int index, int k,
                         Boolean[][] dp,
                         HashMap<Integer, Integer> map) {

        // Reached last stone
        if (index == stones.length - 1) {
            return true;
        }

        // Memoization
        if (dp[index][k] != null) {
            return dp[index][k];
        }

        boolean choice1 = false;
        boolean choice2 = false;
        boolean choice3 = false;

        // k-1 jump
        if (k - 1 > 0) {
            int nextPos = stones[index] + (k - 1);

            if (map.containsKey(nextPos)) {
                choice1 = solve(stones, map.get(nextPos), k - 1, dp, map);
            }
        }

        // k jump
        {
            int nextPos = stones[index] + k;

            if (map.containsKey(nextPos)) {
                choice2 = solve(stones, map.get(nextPos), k, dp, map);
            }
        }

        // k+1 jump
        {
            int nextPos = stones[index] + (k + 1);

            if (map.containsKey(nextPos)) {
                choice3 = solve(stones, map.get(nextPos), k + 1, dp, map);
            }
        }

        return dp[index][k] = choice1 || choice2 || choice3;
    }

    public boolean canCross(int[] stones) {

        if (stones.length < 2 || stones[1] != 1) {
            return false;
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < stones.length; i++) {
            map.put(stones[i], i);
        }

        // dp[index][lastJump]
        Boolean[][] dp = new Boolean[stones.length][stones.length + 1];

        return solve(stones, 1, 1, dp, map);
    }
}