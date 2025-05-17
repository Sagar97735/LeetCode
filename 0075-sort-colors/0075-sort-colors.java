class Solution {
    public void sortColors(int[] nums) {
        int cnt0 = 0;
        int cnt1 = 0;
        int cnt2 = 0;
    for(int i = 0; i<nums.length; i++){
        if(nums[i]==0){
            cnt0++;
        }
        if(nums[i]==1){
            cnt1++;
        }
        if(nums[i]==2){
            cnt2++;
        }
    }
    for(int i =0; i<nums.length; i++){
        if(cnt0!=0){
            nums[i]=0;
            cnt0--;
        }
        else if(cnt1!=0){
            nums[i]=1;
            cnt1--;
        }
        else if(cnt2!=0){
             nums[i]=2;
             cnt2--;
        }
    }
    
    }
}