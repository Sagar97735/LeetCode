class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int [] arr = new int [2];
        int j = 0;
        HashMap<Integer,Integer> h1 = new HashMap<>();
        for(int i = 0; i<nums.length; i++){
        h1.put(nums[i],h1.getOrDefault(nums[i],0)+1);
            }
        for(Map.Entry<Integer,Integer> e1 : h1.entrySet()){
            int key = e1.getKey();
            int val = e1.getValue();
            if(val>1 && j<2){
                arr[j] = key;
                j++;
            }
        } 
         
        return arr;
    }
}