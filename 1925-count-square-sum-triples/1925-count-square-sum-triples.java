class Solution {
    public int countTriples(int n) {
        int ans = 0;
        for(int i =1; i<=n; i++){
            for(int j =1; j<=n; j++){
                int c = i*i + j*j;
                int sqr = (int)Math.sqrt(c);
               if(sqr*sqr==c && sqr<=n){
                ans++;
               }
            }
        }
        return ans;
    }
}