class Solution {
    public int countSubarrays(int[] nums) {
        
    int cnt = 0;
    int i =0;
    int j =2;
    while(j<nums.length){
        double sum = 0;
        sum+=nums[i];
        sum+=nums[j];
     if(sum==((double)(nums[i+1]))/2){
        cnt++;
     }
     j++;
     i++;
    }
    return cnt;
    }
}