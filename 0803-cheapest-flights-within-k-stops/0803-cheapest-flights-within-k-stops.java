import java.util.*;

class Solution {
    public class Pair {
        int city;
        int cost;
        int stops;
        public Pair(int city, int cost, int stops) {
            this.city = city;
            this.cost = cost;
            this.stops = stops;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] flight : flights) {
            int s = flight[0], d = flight[1], c = flight[2];
            graph.get(s).add(new Pair(d, c, 0));
        }
        
        // Min heap (Priority Queue) to always process the cheapest cost first
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(src, 0, 0));

        // Track minimum cost to reach each node with `stops`
        int[][] dist = new int[n][k + 2];
        for (int[] d : dist) {
            Arrays.fill(d, Integer.MAX_VALUE);
        }
        dist[src][0] = 0;
        
        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            int city = p.city, cost = p.cost, stops = p.stops;

            if (stops > k) continue;

            for (Pair neighbor : graph.get(city)) {
                int newCost = cost + neighbor.cost;
                if (newCost < dist[neighbor.city][stops + 1]) {
                    dist[neighbor.city][stops + 1] = newCost;
                    queue.add(new Pair(neighbor.city, newCost, stops + 1));
                }
            }
        }

        int minCost = Integer.MAX_VALUE;
        for (int i = 0; i <= k + 1; i++) {
            minCost = Math.min(minCost, dist[dst][i]);
        }

        return minCost == Integer.MAX_VALUE ? -1 : minCost;
    }
}
