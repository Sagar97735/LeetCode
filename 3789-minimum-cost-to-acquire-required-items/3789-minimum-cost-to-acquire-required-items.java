class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {

        long p1 = Math.min(cost1, costBoth);
        long p2 = Math.min(cost2, costBoth);
        long both = Math.min((long) cost1 + cost2, costBoth);

        long ans = 0;

        if ((long) cost1 + cost2 < costBoth) {
            ans = (long) cost1 * need1 + (long) cost2 * need2;
        } else {
            if (need1 >= need2) {
                ans += both * need2;
                need1 -= need2;
                ans += p1 * need1;
            } else {
                ans += both * need1;
                need2 -= need1;
                ans += p2 * need2;
            }
        }

        return ans;
    }
}
