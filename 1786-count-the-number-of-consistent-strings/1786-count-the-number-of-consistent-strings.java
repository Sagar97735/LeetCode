class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int size = allowed.length();
        int ans = 0;
        for(int i = 0; i< words.length; i++){
           for(int j =0; j<words[i].length(); j++){
            String str = words[i];
            if(allowed.indexOf(str.charAt(j))==-1){
                break;
            }
            if(j==words[i].length()-1){
                ans++;
            }
           }
        }
        return ans;
    }
}