class Solution {
    public int minAddToMakeValid(String s) {
        int ans= 0;
        Stack<Character> s1 = new Stack<>();
        for(int i = 0; i<s.length(); i++){
          if(s.charAt(i)=='('){
            s1.push(s.charAt(i));
          }
           else if(s1.size()!=0 && s.charAt(i)==')'){
            s1.pop();
          }
          else{
            ans++;
          }
        }
        return ans + s1.size();
    }
}