class Solution {
    // Find function with path compression
    public int find(int i,int [] parent) {
        if (parent[i] != i) {
            parent[i] = find(parent[i],parent); // Path compression
        }
        return parent[i];
    }

    // Union function with union by rank
     public void union(int x, int y, int parent[], int rank[]){
        int x_parent = find(x, parent);
        int y_parent = find(y, parent);
        if(x_parent == y_parent) return;

        if(rank[x_parent] > rank[y_parent]){
            parent[y_parent] = x_parent;
        } else if(rank[x_parent] < rank[y_parent]){
            parent[x_parent] = y_parent;
        } else {
            parent[x_parent] = y_parent;
            rank[y_parent]++;
        }
    }

    public int removeStones(int[][] stones) {
     int n = stones.length;
      int parent[] = new int[n];
        int rank[] = new int[n];

        // Initialize parent and rank arrays
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        // Union stones that are in the same row or column
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    union(i, j,parent,rank);
                }
            }
        }

        // Count the number of disjoint sets (connected components)
        int groups = 0;
        for (int i = 0; i < n; i++) {
            if (parent[i] == i) {
                groups++;
            }
        }

        // The number of stones that can be removed is total stones - number of groups
        return n - groups;
    }
}