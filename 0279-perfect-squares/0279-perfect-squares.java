class Solution {
    public int numSquares(int n) {
        int [] arr = new int[n+1];
        return solve(n,arr);
    }
    public int solve(int n,int [] arr){
       if(n<4){
            return n;
        }
        if(arr[n]!=0){
            return arr[n];
        }
        int result = Integer.MAX_VALUE;
        for(int i =1; i*i<=n; i++){
            int a = i*i;
            int min = 1+ solve(n-a,arr);
            result = Math.min(result,min);
        }
        return arr[n] = result;
    }
}