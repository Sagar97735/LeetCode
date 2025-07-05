class Solution {
    public int findLucky(int[] arr) {
        int [] freq = new int [1000];
        int max = -1;
        for(int i = 0 ; i<arr.length; i++){
            freq[arr[i]]++;
        }
        for(int i =1; i<freq.length; i++){
            if(freq[i]==i){
                max = Math.max(freq[i],max);            }
        }
        return max;
    }
}