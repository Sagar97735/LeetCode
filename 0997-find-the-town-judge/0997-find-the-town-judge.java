class Solution {
    public int findJudge(int n, int[][] trust) {
        if(n==1){
            return 1;
        }
        int [] arr = new int [n+1];
        int max = 0;
        int ans = -1;
        for(int i =0; i<trust.length; i++){
           int u = trust[i][0];
           int v = trust[i][1];
           if(u!=v){
            arr[v] = arr[v]+1;
            if(arr[v]>max){
                  max = Math.max(max,arr[v]);
                  ans = v;
            }
           }
        }
        int cnt =0;
        
        if(max==n-1){
            for(int i =0; i<trust.length; i++){
                if(trust[i][0]==ans){
                    return -1;
                }
            }
            return ans;
        }
        return -1;
    }
}