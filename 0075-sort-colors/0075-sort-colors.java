// ------------------------->approach1<---------------------------------
// class Solution {
//     public void sortColors(int[] nums) {
//         int cnt0 = 0;
//         int cnt1 = 0;
//         int cnt2 = 0;
//     for(int i = 0; i<nums.length; i++){
//         if(nums[i]==0){
//             cnt0++;
//         }
//         if(nums[i]==1){
//             cnt1++;
//         }
//         if(nums[i]==2){
//             cnt2++;
//         }
//     }
//     for(int i =0; i<nums.length; i++){
//         if(cnt0!=0){
//             nums[i]=0;
//             cnt0--;
//         }
//         else if(cnt1!=0){
//             nums[i]=1;
//             cnt1--;
//         }
//         else if(cnt2!=0){
//              nums[i]=2;
//              cnt2--;
//         }
//     }

//     }
// }
// ------------------------->Approach2<----------------------------------
class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;

        int i = 0;   // denotes for 0
        int j = 0;   // denotes for 1
        int k = n - 1; // denotes for 2

        while (j <= k) {
            if (nums[j] == 1) {
                j++;
            } else if (nums[j] == 2) {
                //swap with nums[k]
                int temp = nums[j];
                nums[j] = nums[k];
                nums[k] = temp;
                k--;
            } else { // if nums[j] == 0
             //swap with nums[i]
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                i++;
                j++;
            }
        }
    }
}