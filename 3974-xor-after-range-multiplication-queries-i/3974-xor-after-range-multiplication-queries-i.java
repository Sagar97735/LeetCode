class Solution {
    public void solve(int [] nums, int i ,int max,int jump,int product){
        int a = 1000000007;
        while(i<=max){
            nums[i] = (int)(((long)nums[i] * product) % a);
            i+=jump;
        }
    }
    public int xorAfterQueries(int[] nums, int[][] queries) {
        for(int i = 0; i<queries.length; i++){
            int li = queries[i][0];
            int ri = queries[i][1];
            int ki = queries[i][2];
            int vi = queries[i][3];
            solve(nums,li,ri,ki,vi);
        }
        int ans = nums[0];
        for(int i =1; i<nums.length; i++){
            ans^=nums[i];
        }
        return ans;
    }

}