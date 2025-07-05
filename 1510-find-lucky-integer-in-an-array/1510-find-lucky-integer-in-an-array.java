class Solution {
    public int findLucky(int[] arr) {
    int max = -1;
    int [] freq = new int [505];
    for(int i =0; i<arr.length; i++){
      int num = arr[i];
      freq[num]++;  
    }
    for(int i =1; i<freq.length; i++){
        if(freq[i]==i){
            max = Math.max(max,i);
        }
    }
    return max;
    }
}