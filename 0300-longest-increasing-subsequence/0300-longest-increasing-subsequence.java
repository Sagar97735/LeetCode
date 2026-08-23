// class Solution {
//     public int lengthOfLIS(int[] nums) {
//         int [] dp = new int[nums.length];
//         Arrays.fill(dp,1);
//         for(int i =0; i<nums.length; i++){
//             for(int j =0; j<i; j++){
//                 if(nums[j]<nums[i]){
//                     dp[i] = Math.max(dp[i],1+dp[j]);
//                 }
//             }
//         }
//         int max = 0;
//         for(int i =0; i<dp.length; i++){
//             max = Math.max(max,dp[i]);
//         }
//         return max;
//     }
// }
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] temp = new int[n];

        int len = 0;

        for (int num : nums) {

            int low = 0;
            int high = len;

            // Lower Bound
            while (low < high) {
                int mid = low + (high - low) / 2;

                if (temp[mid] < num) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }

            temp[low] = num;
   
            if (low == len) {
                len++;
            }
        }

        return len;
    }
}