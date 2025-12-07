class Solution {
    public int numberOfSubstrings(String s) {
      int [] arr = new int [3];
      int cnt = 0;
        int i =0;
        int j = 0;
        while(i<=s.length()-3 && j<s.length()){
            arr[s.charAt(j)-'a']++;
         while(arr[0]>0 && arr[1]>0 && arr[2]>0){
                   cnt+=(s.length()-j);
                   arr[s.charAt(i)-'a']--;
                   i++;
            } 
           j++;
        }
        return cnt;
    }
}