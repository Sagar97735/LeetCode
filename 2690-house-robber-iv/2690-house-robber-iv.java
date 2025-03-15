class Solution {
    public int minCapability(int[] nums, int k) {
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    for(int i =0; i<nums.length; i++){
        if(nums[i]<min){
            min = nums[i];
        }
         if(nums[i]>max){
            max = nums[i];
        }
    }
    int start = min;
    int end = max;
    while(start<end){
        int mid = (start+end)/2;
        if(ispossible(mid,nums,k)){
            end = mid;
        }
        else{
            start = mid+1;
        }

    }
    return start;
    }
    public boolean ispossible(int mid,int nums[],int k){
        int cnt = 0;
        for(int i =0; i<nums.length; i++){
            if(nums[i]<=mid){
                cnt++;
                i++;
            }
            if(cnt ==k){
                break;
            }       
        }
        if(cnt==k){
            return true;
        }
        return false;
    }
}