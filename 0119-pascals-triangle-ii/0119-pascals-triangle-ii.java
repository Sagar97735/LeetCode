class Solution {
    public List<Integer> solve(int row){
         List<List<Integer>> arr = new ArrayList<>();
         for(int i =0; i<=row; i++){
            arr.add(new ArrayList<>());
         }
         arr.get(0).add(1);
         for(int i =1; i<=row; i++){
            arr.get(i).add(1);
            int j =0;
            while(j+1<arr.get(i-1).size()){
               arr.get(i).add(arr.get(i-1).get(j)+arr.get(i-1).get(j+1));
               j++;
            }
            arr.get(i).add(1);
         }
         return arr.get(row);
    }
    public List<Integer> getRow(int rowIndex) {
       return solve(rowIndex);
    }
}