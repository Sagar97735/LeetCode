// class Solution { 
//     public int solve(int n,int [] arr){
//        if(n<4){
//             return n;
//         }
//         if(arr[n]!=0){
//             return arr[n];
//         }
//         int result = Integer.MAX_VALUE;
//         for(int i =1; i*i<=n; i++){
//             int a = i*i;
//             int min = 1+ numSquares(n-a);
//             result = Math.min(result,min);
//         }
//         return arr[n] = result;
//     }
//     public int numSquares(int n) {
//         int [] arr = new int[n+1];
//         return solve(n,arr);
//     }
// }
// Time complexity: O(N * sqrt(N))
// Space complexity: O(N)
	
class Solution {
    public int numSquares(int n) {
        int[] memo = new int[n + 1];
        return helper(n, memo);
    }
    
    public int helper(int n, int[] memo) {
        if (n < 4)
            return n;
        
        if (memo[n] != 0)
            return memo[n];
        
        int ans = n;
        
        for (int i = 1; i * i <= n; i++) {
            int square = i * i;
            ans = Math.min(ans, 1 + helper(n - square, memo));
        }
        
        return memo[n] = ans;
    }
}