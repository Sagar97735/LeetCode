class Solution {
    public int maximumUniqueSubarray(int[] nums) {
    HashSet<Integer> h1 = new HashSet<>();
    int max = 0;
    int sum = 0;
    int i =0;
    int j =0;
    while(j<nums.length){
        if(h1.contains(nums[j])){
            sum-=nums[i];
            h1.remove(nums[i]);
             i++;
        }
        else{
            sum+=nums[j];
            h1.add(nums[j]);
            max = Math.max(max,sum);
            j++;
        }
    }
    return max;    
    }
}