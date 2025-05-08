class Solution {
    public int find(int i, int[] parent) {
        if (i == parent[i]) {
            return i;
        }
        return parent[i] = find(parent[i], parent);
    }

    public void union(int a, int b, int[] parent) {
        int a_parent = find(a, parent);
        int b_parent = find(b, parent);
        if (a_parent != b_parent) {
            parent[b_parent] = a_parent;
        }
    }

    public int maxNumEdgesToRemove(int n, int[][] edges) {
        Arrays.sort(edges, (a, b) -> Integer.compare(b[0], a[0]));
        int[] parent1 = new int[n + 1];
        int[] parent2 = new int[n + 1];
        for (int i = 1; i <= n; i++) {
           parent1[i] = i;
          parent2[i] = i;
}
        int component1 = n;
        int component2 = n;
        int ans = 0;
        for (int i = 0; i < edges.length; i++) {
            int type = edges[i][0];
            int u = edges[i][1];
            int v = edges[i][2];
            if (type == 3) {
                int a1 = find(u, parent1);
                int b1 = find(v, parent1);
                int a2 = find(u, parent2);
                int b2 = find(v, parent2);
                boolean used = false;

                if (a1 != b1) {
                    union(u, v, parent1);
                    component1--;
                    used = true;
                }

                if (a2 != b2) {
                    union(u, v, parent2);
                    component2--;
                    used = true;
                }

                if (!used) {
                    ans++;
                }
            }

           else if (type == 1) {
                int a = find(u, parent1);
                int b = find(v, parent1);

                if (a != b) {
                    union(u, v, parent1);
                    component1--;
                }
                else{
                    ans++;
                }

            }
             else if (type == 2) {  
                int a = find(u, parent2);
                int b = find(v, parent2);
                if (a != b) {
                    union(u, v, parent2);
                    component2--;
                } else {
                    ans++;
                }
            }
        }
if(component1==1 && component2==1){
    return ans;
}
    return -1;
    }
}