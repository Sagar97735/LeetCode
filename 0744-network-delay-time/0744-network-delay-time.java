class Solution {
    public class couple implements Comparable<couple>{
        int node;
        int sec;
        public couple(int node, int sec){
            this.node = node;
            this.sec = sec;
            }
            @Override
        public int compareTo(couple c2){
            return this.sec - c2.sec;
        }
        
    }
    public class Pair{
        int dest;
        int time;
        public Pair(int v, int t){
            this.dest = v;
            this.time = t;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Pair>> arr = new ArrayList<>();
        for(int i =0; i<n+1;i++){
         arr.add(new ArrayList<>());
        }
        for(int i = 0; i<times.length;i++){
            arr.get(times[i][0]).add(new Pair(times[i][1],times[i][2]));
        }
    PriorityQueue<couple> q1 = new PriorityQueue<>();
    q1.add(new couple(k,0));
    int [] ans = new int[n+1];
    Arrays.fill(ans,Integer.MAX_VALUE);
    ans[k]=0;
    ans[0]=-1;
    while(!q1.isEmpty()){
        couple c = q1.poll();
        int u = c.node;
        int t = c.sec;
        for(int i = 0; i<arr.get(u).size();i++){
            Pair a = arr.get(u).get(i);
            int b = a.dest;
            int s = a.time;
            if(t+s<ans[b]){
                 ans[b] = t+s;
                 q1.add(new couple(b,t+s));
            }
        }
    }
    int max = -2;
    for(int i =0; i< ans.length; i++){
      if(ans[i]>max){
        max=ans[i];
      }
    }
    if (max==Integer.MAX_VALUE){
        return -1;
    }
    return max;
    }
}