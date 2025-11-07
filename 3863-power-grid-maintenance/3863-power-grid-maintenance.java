import java.util.*;

class Solution {

    // Yeh map har node ko uske component ke PriorityQueue se map karega.
    // Jaise, agar component {2, 5, 8} hai, toh:
    // map[2] -> PQ{2, 5, 8}
    // map[5] -> PQ{2, 5, 8}
    // map[8] -> PQ{2, 5, 8}
    // Isse humein kisi bhi node se uske component ka PQ mil jaayega.
    PriorityQueue<Integer>[] nodeToComponentPQ;

    /**
     * Yeh simple DFS hai.
     * Yeh 'node' se start karta hai aur uske poore component ko explore karta hai.
     * Saare nodes ko 'componentPQ' mein add kar deta hai.
     * Aur 'nodeToComponentPQ' map ko update karta hai.
     */
    private void findComponent(int node, List<List<Integer>> adj, boolean[] visited, 
                               PriorityQueue<Integer> componentPQ, 
                               PriorityQueue<Integer>[] nodeToComponentPQ) {
        
        visited[node] = true;
        componentPQ.add(node); // Node ko uske component ke PQ mein daalo
        nodeToComponentPQ[node] = componentPQ; // Is node ko PQ se map karo

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                findComponent(neighbor, adj, visited, componentPQ, nodeToComponentPQ);
            }
        }
    }

    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        // 1. Graph Banao (Tumhara original code)
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= c; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] conn : connections) {
            adj.get(conn[0]).add(conn[1]);
            adj.get(conn[1]).add(conn[0]);
        }

        // 2. Components Find Karo (DFS + PQ)
        int numNodes = c + 1;
        nodeToComponentPQ = new PriorityQueue[numNodes];
        boolean[] visited = new boolean[numNodes];

        for (int i = 0; i <= c; i++) {
            if (!visited[i]) {
                // Ek naya component mila. Iske liye ek naya PQ banao.
                PriorityQueue<Integer> currentComponentPQ = new PriorityQueue<>();
                // Is component ke saare nodes find karo aur PQ mein daalo
                findComponent(i, adj, visited, currentComponentPQ, nodeToComponentPQ);
            }
        }

        // 3. Queries Process Karo
        List<Integer> ansList = new ArrayList<>();
        Set<Integer> h1 = new HashSet<>(); // Tumhara "special" set

        for (int[] query : queries) {
            int type = query[0];
            int b = query[1];

            if (type == 2) {
                // Type 2: Node ko special banao
                h1.add(b);
            } else {
                // Type 1: Query
                if (!h1.contains(b)) {
                    ansList.add(b); // Node special nahi hai, answer woh khud hai
                } else {
                    // Node special hai. Uske component ka PQ nikalo.
                    PriorityQueue<Integer> pq = nodeToComponentPQ[b];

                    // --- YEH HAI MAIN OPTIMIZATION ---
                    // PQ ke top se unn sabhi nodes ko hatao jo 'h1' (special) set mein hain.
                    while (!pq.isEmpty() && h1.contains(pq.peek())) {
                        pq.poll(); // Yeh node special hai, isse ignore karo
                    }

                    // Ab jo top par hai, woh smallest *non-special* node hai
                    if (pq.isEmpty()) {
                        ansList.add(-1); // Poora component special ban gaya
                    } else {
                        ansList.add(pq.peek()); // Answer mil gaya
                    }
                }
            }
        }

        // Final answer ko array mein convert karo
        int[] ansArray = new int[ansList.size()];
        for (int i = 0; i < ansList.size(); i++) {
            ansArray[i] = ansList.get(i);
        }
        return ansArray;
    }
}