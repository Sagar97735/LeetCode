import java.util.*;

class Solution {
    public int minJumps(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return 0;
        }

        int maxVal = 0;
        for (int num : nums) {
            maxVal = Math.max(maxVal, num);
        }

        // Step 1: Pre-computation using Sieve to find Smallest Prime Factors (SPF)
        int[] spf = new int[maxVal + 1];
        for (int i = 0; i <= maxVal; i++) {
            spf[i] = i;
        }

        for (int i = 2; i * i <= maxVal; i++) {
            if (spf[i] == i) { // i is a prime number
                // CORRECTED: j is now an int, as array indices must be ints.
                // The value i*i fits in an int given the problem's constraints.
                for (int j = i * i; j <= maxVal; j += i) {
                    if (spf[j] == j) { // If j's spf is not already marked
                        spf[j] = i;
                    }
                }
            }
        }

        // Step 2: Create a map from prime factors to indices where they appear
        Map<Integer, List<Integer>> primeFactorToIndices = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            if (num == 1) continue;
            int temp = num;
            while (temp > 1) {
                int p = spf[temp];
                primeFactorToIndices.computeIfAbsent(p, k -> new ArrayList<>()).add(i);
                while (temp > 0 && temp % p == 0) {
                    temp /= p;
                }
            }
        }

        // Step 3: BFS to find the shortest path
        Queue<int[]> q = new ArrayDeque<>(); // {index, distance}
        q.offer(new int[]{0, 0});
        int[] dist = new int[n];
        Arrays.fill(dist, -1);
        dist[0] = 0;
        Set<Integer> visitedTeleportPrimes = new HashSet<>();

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int u = current[0];
            int d = current[1];

            if (u == n - 1) {
                return d;
            }

            // Operation 1: Adjacent Step
            if (u + 1 < n && dist[u + 1] == -1) {
                dist[u + 1] = d + 1;
                q.offer(new int[]{u + 1, d + 1});
            }
            if (u - 1 >= 0 && dist[u - 1] == -1) {
                dist[u - 1] = d + 1;
                q.offer(new int[]{u - 1, d + 1});
            }

            // Operation 2: Prime Teleportation
            int p = nums[u];
            if (p > 1 && spf[p] == p) { // Check if nums[u] is a prime
                if (!visitedTeleportPrimes.contains(p)) {
                    visitedTeleportPrimes.add(p);
                    if (primeFactorToIndices.containsKey(p)) {
                        for (int v : primeFactorToIndices.get(p)) {
                            if (dist[v] == -1) {
                                dist[v] = d + 1;
                                q.offer(new int[]{v, d + 1});
                            }
                        }
                    }
                }
            }
        }

        return -1; // Should be unreachable
    }
}