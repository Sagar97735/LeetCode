//recursion
// public int numSquares(int n) {
// 	if (n < 4)
// 		return n;
	
// 	int ans = n;
	
// 	for (int i = 1; i * i <= n; i++) {
// 		int square = i * i;
// 		ans = Math.min(ans, 1 + numSquares(n - square));
// 	}
	
// 	return ans;
// }

//-------------->recursion + memoization<------------
	
// class Solution {
//     public int numSquares(int n) {
//         int [] arr = new int[n+1];
//         return solve(n,arr);
//     }
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
//             int min = 1+ solve(n-a,arr);
//             result = Math.min(result,min);
//         }
//         return arr[n] = result;
//     }
// }
// --------------------> Buttom up dp <-----------------------
class Solution {
public int numSquares(int n) {
	int[] dp = new int[n + 1];
	dp[0] = 0;
	
	for (int i = 1; i <= n; i++) {
		dp[i] = i;
		
		for (int j = 1; j * j <= i; j++) {
			int square = j * j;
			dp[i] = Math.min(dp[i], 1 + dp[i - square]);
		}
	}
	
	return dp[n];
}
}