class FindSumPairs {
    int [] nums1;
    int [] nums2;
    Map<Integer,Integer> h1;
    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        h1 = new HashMap<>();
        for(int i = 0; i<nums2.length; i++){
            h1.put(nums2[i],h1.getOrDefault(nums2[i],0)+1);
        }
    }
    
    public void add(int index, int val) {
         int oldval = nums2[index];
         int newval = nums2[index]+val;
         nums2[index] = newval;
         h1.put(newval,h1.getOrDefault(newval,0)+1);
         h1.put(oldval,h1.get(oldval)-1);
         if(h1.get(oldval)==0){
            h1.remove(oldval);
         }
    }
    
    public int count(int tot) {
        int result = 0;
        //nums1[i] +nums2[j]==tot then result+1
        //nums2[j] = tot-nums1[i];
        for(int i =0; i<nums1.length; i++){
            int a = nums1[i];
            int freq = h1.getOrDefault(tot-a,0);
            result=result+freq;
        }
        return result;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */