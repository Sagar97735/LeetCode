class Solution {
    public int residuePrefixes(String s) {
        HashSet<Character> h1 = new HashSet<>();
        int cnt = 0;
        for(int i = 0; i<s.length(); i++){
        char c = s.charAt(i);
        h1.add(c);
         if((i+1)%3 == h1.size()){
            cnt++;
         }
        }
        return cnt;
    }
}