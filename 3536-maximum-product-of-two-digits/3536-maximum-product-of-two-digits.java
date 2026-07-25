class Solution {
    public int maxProduct(int n) {
        List<Integer> arr = new ArrayList<>();
        int max = 0;
        while(n>=1){
            int lastdigit = n%10;
            arr.add(lastdigit);
            n/=10;
        }
         int size = arr.size();
         Collections.sort(arr);
         if(arr.size()>1){
          max = Math.max(arr.get(size-1)*arr.get(size-2),max);
         }
         
         return max;
    }
}