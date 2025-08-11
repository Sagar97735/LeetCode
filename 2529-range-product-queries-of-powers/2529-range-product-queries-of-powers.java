class Solution {
    public int[] productQueries(int n, int[][] queries) {
        int MOD = 1_000_000_007;

        // Step 1: powers array banate hain
        java.util.List<Integer> powers = new java.util.ArrayList<>();
        for (int i = 0; i < 31; i++) {
            if ((n & (1 << i)) != 0) {
                powers.add(1 << i);
            }
        }

        // Step 2: har query ka product nikalna
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0], r = queries[i][1];
            long product = 1;
            for (int j = l; j <= r; j++) {
                product = (product * powers.get(j)) % MOD;
            }
            ans[i] = (int) product;
        }

        return ans;
    }
}

