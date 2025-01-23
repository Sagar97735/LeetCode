class Solution {
    public int solve(int n, int[] memo){
        if(n==0 || n==1 || n==2){
            return n;
        }
        if(n<0){
            return 0;
        }
        if(memo[n]!=-1){
            return memo[n];
        }
        int option1 = solve(n-1,memo);
        int option2 = solve(n-2 , memo);
    
    return memo[n] = option1+option2;
    }
    public int climbStairs(int n) {
        int [] memo = new int[n+1];
        Arrays.fill(memo,-1);
        int ans = solve(n,memo);
        return ans;
    }
}