class Solution {
    public boolean checkIfExist(int[] arr) {
       HashSet<Integer> h1 = new HashSet<>();
        for(int i = 0; i<arr.length; i++){
            if(h1.contains(arr[i]*2)){
                return true;
            }
            if(arr[i]%2==0 && h1.contains(arr[i]/2)){
                return true;
            }
         else{
            h1.add(arr[i]);
         }
        }
        return false;
    }
}