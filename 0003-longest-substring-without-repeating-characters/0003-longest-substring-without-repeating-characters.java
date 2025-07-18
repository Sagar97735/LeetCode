class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> h1 = new HashSet<>();
        int ans = 0;
        int i = 0;
        int j =0;
        int size = 0;
        while(j<s.length()){
             if(!h1.contains(s.charAt(j))){
                 h1.add(s.charAt(j));
                 j++;
                 size++;
                 ans = Math.max(ans,size);
             }
             else{
                h1.remove(s.charAt(i));
                i++;
                size-=1;
             }
        }

        return ans;
    }
}