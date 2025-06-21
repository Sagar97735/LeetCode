import java.util.*;

class Solution {
    int n;
    Map<String, Integer> memo = new HashMap<>();

    public int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public int isSolve(int[] nums, boolean[] visit, int operation) {
        StringBuilder keyBuilder = new StringBuilder();
        for (boolean b : visit) keyBuilder.append(b ? '1' : '0');
        keyBuilder.append("_").append(operation);
        String key = keyBuilder.toString();

        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int maxscore = 0;
        for (int i = 0; i < n - 1; i++) {
            if (visit[i]) continue;
            for (int j = i + 1; j < n; j++) {
                if (visit[j]) continue;

                visit[i] = true;
                visit[j] = true;

                int currScore = operation * gcd(nums[i], nums[j]);
                int remainingScore = isSolve(nums, visit, operation + 1);
                maxscore = Math.max(maxscore, currScore + remainingScore);

                visit[i] = false;
                visit[j] = false;
            }
        }

        memo.put(key, maxscore);
        return maxscore;
    }

    public int maxScore(int[] nums) {
        n = nums.length;
        boolean[] visit = new boolean[n];
        return isSolve(nums, visit, 1);
    }
}
