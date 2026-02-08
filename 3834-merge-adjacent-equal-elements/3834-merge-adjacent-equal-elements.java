class Solution {
    public List<Long> mergeAdjacent(int[] nums) {
        List<Long> arr = new ArrayList<>();
     

        for(int i =0; i<nums.length; i++){
            arr.add((long)nums[i]);
        }

        int i = 0;
        while (i + 1 < arr.size()) {
            if (arr.get(i).equals(arr.get(i + 1))) {
                arr.set(i, arr.get(i) * 2);
                arr.remove(i + 1);
                if (i > 0) i--;
            }
             else {
                i++;
            }
        }

        return arr;
    }
}
