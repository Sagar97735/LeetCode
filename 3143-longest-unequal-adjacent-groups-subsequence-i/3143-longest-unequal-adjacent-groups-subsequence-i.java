class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> arr = new ArrayList<>();
        List<String> arr1 = new ArrayList<>();
        int a = 0;
        int b = 1;
        for(int i =0; i<groups.length; i++){
          if(groups[i]==a){
            arr.add(words[i]);
            a=1-a;
          }
        }
        for(int i =0; i<groups.length; i++){
          if(groups[i]==b){
            arr1.add(words[i]);
            b=1-b;
          }
        }
      return arr1.size()>arr.size()?arr1:arr;
    }
}