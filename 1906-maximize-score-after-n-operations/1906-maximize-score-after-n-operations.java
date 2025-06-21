import java.util.*;

class Solution {
    int n;
    int[] nums;
    int[][] gcdCache; // Precompute GCDs
    Map<String, Integer> memo = new HashMap<>();

    public int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public int isSolve(int mask, int operation) {
        if (memo.containsKey(mask + "," + operation)) {
            return memo.get(mask + "," + operation);
        }

        int maxscore = 0;
        for (int i = 0; i < n - 1; i++) {
            if ((mask & (1 << i)) != 0) continue; // already visited
            for (int j = i + 1; j < n; j++) {
                if ((mask & (1 << j)) != 0) continue;

                int newMask = mask | (1 << i) | (1 << j);
                int currScore = operation * gcdCache[i][j];
                int remainingScore = isSolve(newMask, operation + 1);
                maxscore = Math.max(maxscore, currScore + remainingScore);
            }
        }

        memo.put(mask + "," + operation, maxscore);
        return maxscore;
    }

    public int maxScore(int[] nums) {
        this.n = nums.length;
        this.nums = nums;
        this.gcdCache = new int[n][n];

        // Precompute all GCDs
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                gcdCache[i][j] = gcd(nums[i], nums[j]);
            }
        }

        return isSolve(0, 1); // start with empty mask and operation 1
    }
}
