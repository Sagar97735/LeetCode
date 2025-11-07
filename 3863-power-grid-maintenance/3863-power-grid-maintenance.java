import java.util.*;

class Solution {
    int[] parent;
    // Har component ke root par ek PriorityQueue (Min-Heap) store karenge.
    PriorityQueue<Integer>[] pqs;

    /**
     * Standard DSU Find function with path compression.
     */
    private int find(int i) {
        if (parent[i] == i) {
            return i;
        }
        return parent[i] = find(parent[i]);
    }

    /**
     * Custom DSU Union function.
     * Yeh do components ko merge karta hai aur unki PriorityQueues ko bhi merge karta hai.
     * Hamesha chhota PQ, bade PQ mein merge hoga efficiency ke liye.
     */
    private void union(int i, int j) {
        int rootI = find(i);
        int rootJ = find(j);
        
        if (rootI == rootJ) {
            return; // Pehle se hi same component mein hain
        }

        // Ensure rootI hamesha bade size wala PQ ho
        if (pqs[rootI].size() < pqs[rootJ].size()) {
            int temp = rootI;
            rootI = rootJ;
            rootJ = temp;
        }

        // Chhote PQ (rootJ) ko bade PQ (rootI) mein merge karo
        pqs[rootI].addAll(pqs[rootJ]);
        
        // DSU parent set karo
        parent[rootJ] = rootI;
        
        // Chhote PQ ko clear kar sakte hain (optional, memory bachane ke liye)
        // pqs[rootJ] = null; 
    }

    /**
     * Tumhara original `solve` function is function se replace ho gaya hai.
     * Yeh TLE nahi dega.
     */
    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        // Tumhare original code mein nodes 0 se c tak the.
        int numNodes = c + 1; 
        
        parent = new int[numNodes];
        // PriorityQueue ka array initialize karna.
        // Yeh line important hai: new PriorityQueue[numNodes];
        pqs = (PriorityQueue<Integer>[]) new PriorityQueue[numNodes];

        // Har node ko DSU mein initialize karo
        for (int i = 0; i < numNodes; i++) {
            parent[i] = i;
            pqs[i] = new PriorityQueue<Integer>();
            pqs[i].add(i); // Har node ki PQ mein shuru mein sirf woh khud hai
        }

        // Graph build karo DSU ka use karke
        for (int[] conn : connections) {
            union(conn[0], conn[1]);
        }

        List<Integer> ansList = new ArrayList<>();
        Set<Integer> h1 = new HashSet<>(); // "Special" nodes (tumhara h1)

        for (int[] query : queries) {
            int type = query[0];
            int b = query[1];

            if (type == 2) {
                // Type 2: Node ko special set mein add karo
                h1.add(b);
            } else {
                // Type 1: Query
                // Tumhara original special case
                if (!h1.contains(b)) {
                    ansList.add(b);
                } else {
                    // Node special hai, toh component ka smallest non-special find karo
                    int rootB = find(b);
                    PriorityQueue<Integer> componentPQ = pqs[rootB];

                    // --- YEH HAI MAIN OPTIMIZATION ---
                    // PQ ke top se unn sabhi nodes ko hatao jo ab 'h1' set mein hain.
                    // Yeh 'lazily' hota hai, sirf query ke time.
                    while (!componentPQ.isEmpty() && h1.contains(componentPQ.peek())) {
                        componentPQ.poll(); // Smallest node special hai, use hatao
                    }

                    // Ab jo top par hai, woh smallest *non-special* node hai
                    if (componentPQ.isEmpty()) {
                        ansList.add(-1); // Poora component special ban gaya
                    } else {
                        ansList.add(componentPQ.peek()); // Answer mil gaya
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