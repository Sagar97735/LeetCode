//----------------->DFS solution <-------------------------
// class Solution {
//     double answer = 0.0;
//     public class Pair{
//         int x;
//         double pb;
//         public Pair(int x, double pb){
//             this.x = x ;
//             this.pb = pb;
//         }
//     }
//     public void dfs(List<List<Pair>> arr,int src,double ans,int end,boolean [] visited){
//         if(src == end){
//          answer = Math.max(ans,answer);
//          return;
//         }
//         visited[src] = true;
//         for(int i =0; i<arr.get(src).size();i++){
//             Pair p = arr.get(src).get(i);
//             int dest = p.x;
//             double prob = p.pb;
//             if(!visited[dest]){
//                 dfs(arr,dest,ans*prob,end,visited);
//             }
//         }
//         visited[src] = false;
//         return;
//     }
//     public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
//         List<List<Pair>> arr = new ArrayList<>();
//         for(int i =0; i<n; i++){
//             arr.add(new ArrayList<>());
//         }
//         for(int i =0; i<edges.length; i++){
//             int src = edges[i][0];
//             int dest = edges[i][1];
//              double prob = succProb[i];
//             arr.get(src).add(new Pair(dest,prob));
//             arr.get(dest).add(new Pair(src,prob));
            
//         }
//         boolean [] visited = new boolean[n];
//         dfs(arr,start_node,1.0,end_node,visited);
//         return answer;
//     }
// }
class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        // Build the graph
        Map<Integer, List<Pair<Integer, Double>>> graph = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0], v = edges[i][1];
            double pathProb = succProb[i];
            graph.computeIfAbsent(u, k -> new ArrayList<>()).add(new Pair<>(v, pathProb));
            graph.computeIfAbsent(v, k -> new ArrayList<>()).add(new Pair<>(u, pathProb));
        }

        // Array to store the maximum probability to reach each node
        double[] maxProb = new double[n];
        maxProb[start] = 1d;

        // Max-heap priority queue to explore the highest probability first
        PriorityQueue<Pair<Double, Integer>> pq = new PriorityQueue<>((a, b) -> -Double.compare(a.getKey(), b.getKey()));
        pq.add(new Pair<>(1.0, start));

        while (!pq.isEmpty()) {
            Pair<Double, Integer> cur = pq.poll();
            double curProb = cur.getKey();
            int curNode = cur.getValue();

            // If the current node is the end node, return the probability
            if (curNode == end) {
                return curProb;
            }

            // Explore the neighbors
            for (Pair<Integer, Double> nxt : graph.getOrDefault(curNode, new ArrayList<>())) {
                int nxtNode = nxt.getKey();
                double pathProb = nxt.getValue();

                // Update the probability if a higher one is found
                if (curProb * pathProb > maxProb[nxtNode]) {
                    maxProb[nxtNode] = curProb * pathProb;
                    pq.add(new Pair<>(maxProb[nxtNode], nxtNode));
                }
            }
        }

        // If the end node is not reachable, return 0
        return 0d;
    }
}