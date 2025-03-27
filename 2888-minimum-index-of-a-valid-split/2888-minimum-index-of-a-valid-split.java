class Solution {
    public int minimumIndex(List<Integer> nums) {
        HashMap<Integer,Integer> h1 = new HashMap<>();
        int cnt = 0;
        int val = -1;
        for(int i : nums){
            if(!h1.containsKey(i)){
                h1.put(i,1);
            }
            else{
                h1.put(i,1+h1.get(i));
            }
            if(cnt<h1.get(i)){
            cnt = Math.max(cnt,h1.get(i));
            val = i;
        }
        }
        int idx = 0;
        int cnt1 = 0;
        while(idx<nums.size()){
            if(nums.get(idx)==val){
                cnt1++;
            }
            int size1 = idx+1;
            int size2 = nums.size()-size1;
            int cnt2 = cnt - cnt1;
            if(cnt1>(size1/2) && cnt2>(size2/2)){
                return idx;
            }
            idx++;
        }
        
        return -1;
    }
}