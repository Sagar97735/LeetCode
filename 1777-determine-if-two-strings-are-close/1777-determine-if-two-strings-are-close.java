class Solution {
    public boolean closeStrings(String word1, String word2) {
        HashMap<Character,Integer> map = new HashMap<>();
        if(word1.length()!=word2.length()){
            return false;
        }
        int [] arr = new int[26];
        int [] arr1 = new int[26];
       for(int i = 0; i< word1.length();i++){
           arr[word1.charAt(i)-'a']++;
           arr1[word2.charAt(i)-'a']++;
       }
        for(int i = 0; i< arr.length;i++){
         if(arr[i]==0 && arr1[i]>0){
            return false;
         }
         else if(arr1[i]==0 && arr[i]>0){
            return false;
         }}
         Arrays.sort(arr);
         Arrays.sort(arr1);
         return Arrays.equals(arr,arr1);
       

    }
}