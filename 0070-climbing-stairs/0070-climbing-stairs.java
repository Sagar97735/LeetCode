class Solution {
    //------------> recursion (top down approach) <--------------------------
    // public int solve(int n, int[] memo){
    //     if(n==0 || n==1 || n==2){
    //         return n;
    //     }
    //     if(n<0){
    //         return 0;
    //     }
    //     if(memo[n]!=-1){
    //         return memo[n];
    //     }
    //     int option1 = solve(n-1,memo);
    //     int option2 = solve(n-2 , memo);
    
    // return memo[n] = option1+option2;
    // }
    public int climbStairs(int n) {
        // -------------------> recursion <---------------------
        // int [] memo = new int[n+1];
        // Arrays.fill(memo,-1);
        // int ans = solve(n,memo);
        // return ans;

        //----------->buttom up <------------------------
        int [] arr = new int[n+1];
        arr[0] = 0;
        arr[1] = 1;

        if(n>1){
            arr[2] = 2;
        }
        for(int i =3; i<arr.length; i++){
            arr[i] = arr[i-1] + arr[i-2];
        }
        return arr[arr.length -1];
    }
}