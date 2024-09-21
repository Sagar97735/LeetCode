class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int size = allowed.length();
        int ans = 0;
        for(int i = 0; i< words.length; i++){
            String str = words[i];
           for(int j =0; j<str.length(); j++){
            if(allowed.indexOf(str.charAt(j))==-1){
                break;
            }
           else if(j==str.length()-1){
                ans++;
            }
           }
        }
        return ans;
    }
}