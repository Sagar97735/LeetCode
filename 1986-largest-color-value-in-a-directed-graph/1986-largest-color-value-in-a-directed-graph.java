class Solution {
    int max = 0;
    int ans = 0;

    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        List<List<Integer>> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) arr.add(new ArrayList<>());
        
        int[] indegree = new int[n];
        for (int[] edge : edges) {
            arr.get(edge[0]).add(edge[1]);
            indegree[edge[1]]++;
        }

        int[][] freq = new int[n][26]; // freq[i][c] = max freq of char c till node i
        boolean[] visit = new boolean[n]; // visit marker like your original
        boolean[] inrec = new boolean[n]; // reused to track processing status

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) q.add(i);
        }

        int visited = 0;

        while (!q.isEmpty()) {
            int curr = q.poll();
            visited++;
            visit[curr] = true;
            inrec[curr] = false;

            char c = colors.charAt(curr);
            freq[curr][c - 'a']++;
            max = Math.max(max, freq[curr][c - 'a']);

            for (int dest : arr.get(curr)) {
                // update frequencies for dest node from curr
                for (int i = 0; i < 26; i++) {
                    freq[dest][i] = Math.max(freq[dest][i], freq[curr][i]);
                }

                indegree[dest]--;
                if (indegree[dest] == 0) {
                    q.add(dest);
                }
            }
        }

        if (visited != n) return -1; // cycle detected
        return max;
    }
}
