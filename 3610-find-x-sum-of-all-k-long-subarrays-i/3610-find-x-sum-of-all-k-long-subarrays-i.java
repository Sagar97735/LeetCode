class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int [] freq1 = new int[51];
        int [] ans = new int[nums.length-k+1];
        for(int i =0; i<k; i++){
            freq1[nums[i]]++;
        }
        int i = k-1;
        while(i<nums.length){
            int sum = 0;
            int cnt = x;
            int [] freq = freq1.clone();
            while(cnt>0){
             int max = 0;
            int val =0;
            for(int idx = 50; idx>=0; idx--){
               if(freq[idx]>max){
                max = freq[idx];
                val = idx;
               }
            }
            sum += (max*val);
            freq[val] = 0;
            cnt--;
            }
          ans [i-k+1] = sum;
          if(i+1<nums.length){
            freq1[nums[i+1]]++;
            freq1[nums[i-k+1]]--;
          }
          i++;
        }
        return ans;
    }
}