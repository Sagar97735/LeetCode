class Solution {
    public int countPalindromicSubsequence(String s) {
        int [] left = new int[26];
        int [] right = new int[26];
        Arrays.fill(left,-1);
        Arrays.fill(right,-1);
        for(int i = 0; i<s.length(); i++){
            int idx = s.charAt(i)-'a';
            if(left[idx]==-1){
                left[idx] = i;
            }
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            int idx = s.charAt(i) - 'a';
            if (right[idx] == -1) {
                right[idx] = i;
            }
        }
        HashSet<String> h1 = new HashSet<>();
        for(int i =0; i<26; i++){
            if(left[i]!=-1 && right[i]!=-1 && left[i]<right[i] && right[i]-left[i]+1>2){
                for(int j = left[i]+1; j<right[i]; j++){
                    String s1 = "";
                    s1 += s.charAt(left[i]);
                    s1+=s.charAt(j);
                    s1 += s.charAt(left[i]);
                    h1.add(s1);
                }
            }
        }
        return h1.size();
    }
}