import java.util.*;

class Solution {
    int result;

    public int longestPath(int[] parent, String s) {
        int n = parent.length;
        result = 0;

        // Create adjacency list using ArrayList of ArrayLists
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Fill adjacency list
        for (int i = 1; i < n; i++) {
            int u = i;
            int v = parent[i];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        DFS(adj, 0, -1, s);
        return result;
    }

    private int DFS(List<List<Integer>> adj, int curr, int parent, String s) {
        int longest = 0;
        int second_longest = 0;

        for (int child : adj.get(curr)) {
            if (child == parent)
                continue;

            int child_longest_length = DFS(adj, child, curr, s);

            if (s.charAt(child) == s.charAt(curr))
                continue;

            if (child_longest_length > second_longest)
                second_longest = child_longest_length;

            if (second_longest > longest) {
                int temp = longest;
                longest = second_longest;
                second_longest = temp;
            }
        }

        int koi_ek_acha = Math.max(longest, second_longest) + 1; // Including current node
        int only_root_acha = 1; // Only current node
        int neeche_hi_milgaya_answer = longest + second_longest + 1;

        result = Math.max(result, Math.max(neeche_hi_milgaya_answer,
                          Math.max(koi_ek_acha, only_root_acha)));

        return Math.max(koi_ek_acha, only_root_acha);
    }
}
