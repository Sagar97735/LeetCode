class Solution {
    int cnt = 0;

    public class Pair {
        int dest;
        int possible;

        public Pair(int dest,int possible){
            this.dest= dest;
            this.possible = possible;
        }
    }

    public void isSolve(int parent, int curr, List<List<Pair>> arr) {

        for (int i = 0; i < arr.get(curr).size(); i++) {
            int a = arr.get(curr).get(i).dest;
            int check = arr.get(curr).get(i).possible;
            if (a != parent) {
                if (check == 0) {
                    isSolve(curr, a, arr);
                } else if (check == 1) {
                    cnt++;
                    isSolve(curr, a, arr);
                }
            }
        }
        return;
    }

    public int minReorder(int n, int[][] connections) {
        List<List<Pair>> arr = new ArrayList<>();
        for(int i =0; i<n; i++){
            arr.add(new ArrayList<>());
        }
        for(int i =0; i<connections.length; i++){
             int u = connections[i][0];
             int v = connections[i][1];
             arr.get(u).add(new Pair(v,1));
             arr.get(v).add(new Pair(u,0));
        }
        isSolve(-1,0,arr);
        return cnt;
    }
}