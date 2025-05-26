// ------------------------------>using DFS<----------------------------------
// class Solution {
//     int max = 0;
//     int ans = 0;

//     public void isSolve(List<List<Integer>> arr, int curr, int parent, boolean[] visit, boolean[] inrec, int[] freq,
//             String colors,String str) {
//         if (visit[curr]) {
//             if (inrec[curr]) {
//                 ans = -1;
//                 return;
//             }
//         }
//         char c = colors.charAt(curr);
//         str+=curr;
//         freq[c - 'a']++;
//         max = Math.max(max, freq[c - 'a']);
//         visit[curr] = true;
//         inrec[curr] = true;
//         for (int i = 0; i < arr.get(curr).size(); i++) {
//             int dest = arr.get(curr).get(i);
//                 isSolve(arr, dest, curr, visit, inrec, freq, colors,str);
//             } 
        
//         // System.out.println(str);
//         freq[c - 'a']--;
//         inrec[curr] = false;
//         return;
//     }
    

//     public int largestPathValue(String colors, int[][] edges) {
//         List<List<Integer>> arr = new ArrayList<>();
//         for (int i = 0; i < colors.length(); i++) {
//             arr.add(new ArrayList<>());
//         }
//         for (int i = 0; i < edges.length; i++) {
//             int u = edges[i][0];
//             int v = edges[i][1];
//             arr.get(u).add(v);
//         }
//         boolean[] visit = new boolean[colors.length()];
//         boolean[] inrec = new boolean[colors.length()];
//         int[] freq = new int[27];
//         for (int i = 0; i < colors.length(); i++) {
//             if (!visit[i]) {
//                 isSolve(arr, i, -1, visit, inrec, freq, colors, "");
//             }
//         }
//         if (ans == -1) {
//             return ans;
//         }
//         return max;
//     }
// }
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
