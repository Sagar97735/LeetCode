class Solution {
    public long flowerGame(int n, int m) {
       long ans = 0;
       long odd = m/2;
       ans += (n*odd);
       if(m%2!=0){
        ans+=n/2;
       }
       return ans;
    }
}