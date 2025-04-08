class Solution {
    public int minimumOperations(int[] nums) {
        int cnt = 0;
        
        List<Integer> list = new ArrayList<>();
        for(int num : nums){
            list.add(num);
        }
        
        while(true){
            Set<Integer> set = new HashSet<>(list);  // Unique elements
            
            if(set.size() == list.size()){  // All distinct
                break;
            }
            
            // Remove first 3 elements (or all if less than 3)
            int removeCount = Math.min(3, list.size());
            for(int i=0; i<removeCount; i++){
                list.remove(0);
            }
            
            cnt++;
        }
        
        return cnt;
    }
}
