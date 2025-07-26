class Solution {
    public long maxSubarrays(int n, int[][] conflictingPairs) {
        int m = conflictingPairs.length;

        // Step 1: Group conflicts by their smaller index (L)
        List<int[]>[] conflictStartFrom = new List[n + 2];
        for (int i = 0; i <= n + 1; i++) conflictStartFrom[i] = new ArrayList<>();

        for (int id = 0; id < m; id++) {
            int a = conflictingPairs[id][0], b = conflictingPairs[id][1];
            int start = Math.min(a, b);
            int end = Math.max(a, b);
            conflictStartFrom[start].add(new int[]{end, id});
        }

        // Step 2: Prepare info for each index i = 1 to n
        // For every index i, store:
        // - smallest conflict end (minR) and its ID
        // - second smallest end (secondR) and its ID
        int[][] conflictInfo = new int[n + 2][4];
        conflictInfo[n + 1] = new int[]{n + 1, -1, n + 1, -1}; // No conflict beyond n

        for (int i = n; i >= 1; i--) {
            List<int[]> candidates = new ArrayList<>();
            // Add previous best two intervals
            candidates.add(new int[]{conflictInfo[i + 1][0], conflictInfo[i + 1][1]});
            candidates.add(new int[]{conflictInfo[i + 1][2], conflictInfo[i + 1][3]});
            // Add new conflicts starting from index i
            candidates.addAll(conflictStartFrom[i]);

            // Sort by ending point
            candidates.sort((x, y) -> x[0] - y[0]);

            int minR = candidates.get(0)[0];
            int minId = candidates.get(0)[1];
            int secondR = (candidates.size() > 1) ? candidates.get(1)[0] : n + 1;
            int secondId = (candidates.size() > 1) ? candidates.get(1)[1] : -1;

            conflictInfo[i] = new int[]{minR, minId, secondR, secondId};
        }

        // Step 3: Calculate base total of valid subarrays (with all conflicts present)
        long baseTotal = 0;
        for (int i = 1; i <= n; i++) {
            int rightLimit = conflictInfo[i][0];
            baseTotal += (rightLimit - i);
        }

        // Step 4: Calculate gain for removing each conflict
        long[] extraGainIfRemoved = new long[m];
        for (int i = 1; i <= n; i++) {
            int minId = conflictInfo[i][1];
            int secondR = conflictInfo[i][2];
            int minR = conflictInfo[i][0];
            if (minId >= 0) {
                extraGainIfRemoved[minId] += (secondR - minR);
            }
        }

        // Step 5: Pick max gain from removing one conflict
        long maxTotal = baseTotal;
        for (long gain : extraGainIfRemoved) {
            maxTotal = Math.max(maxTotal, baseTotal + gain);
        }

        return maxTotal;
    }
}
