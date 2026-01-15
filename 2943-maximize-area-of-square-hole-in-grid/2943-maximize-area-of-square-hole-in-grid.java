class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        int h = n+2;
        int v = m+2;
        int max1 = 1;
        int max2 = 1;
        int maxh= 1;
        int maxv = 1;
        Arrays.sort(hBars);
        Arrays.sort(vBars);
        for(int i = 1; i<hBars.length; i++){
              if(hBars[i]==hBars[i-1]+1){
                max1 = max1+1;
              }
            else{
                max1 = 1;
            }
             maxh = Math.max(max1,maxh);
        }
        for(int i = 1; i<vBars.length; i++){
             if(vBars[i]==vBars[i-1]+1){
                max2 = max2+1;
              }
              else{
                max2 = 1;
              }
               maxv = Math.max(max2,maxv);
        }
        int a = Math.min(maxh,maxv);
        a = a+1;
        return a*a;
    }
}