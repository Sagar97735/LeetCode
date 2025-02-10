class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>>  arr =  new ArrayList<>(); 
       for(int i =0; i<numRows; i++){
        arr.add(new ArrayList<>());
       }
       arr.get(0).add(1);

       for(int i =1; i<numRows; i++){
        int a =0;
        arr.get(i).add(1);
        while(a<arr.get(i-1).size()-1){
            arr.get(i).add(arr.get(i-1).get(a) + arr.get(i-1).get(a+1));
            a++;
        }
        arr.get(i).add(1);
       }
       return arr;
    }
}