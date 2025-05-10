class Solution {
    int ans = 0;
    int temp = 0;
    public void dfs(List<List<Integer>> arr, int bomb ,boolean[] visited) {
       visited[bomb] = true;
       temp+=1;
        for (int i = 0; i < arr.get(bomb).size(); i++) {
            int neigh = arr.get(bomb).get(i);
            if(!visited[neigh]){
             dfs(arr, neigh, visited);
            }
        }
    }

    public int maximumDetonation(int[][] bombs) {
        List<List<Integer>> arr = new ArrayList<>();
        for (int i = 0; i < bombs.length; i++) {
            int x = bombs[i][0];
            int y = bombs[i][1];
            int r = bombs[i][2];
            List<Integer> arr1 = new ArrayList<>();
            for (int j = 0; j < bombs.length; j++) {
                if (j != i) {
                    int x1 = bombs[j][0];
                    int y1 = bombs[j][1];
                    double dist = Math.pow((x - x1), 2) + Math.pow((y - y1), 2);
                    double d = Math.sqrt(dist);
                    if (d <= r) {
                        arr1.add(j);
                    }
                }
            }
            arr.add(arr1);
        }
        for (int i = 0; i < bombs.length; i++) {
            boolean[] visited = new boolean[bombs.length];
            dfs(arr, i,  visited);
            ans = Math.max(ans,temp);
            temp =0;
        }
        return ans;
    }
}