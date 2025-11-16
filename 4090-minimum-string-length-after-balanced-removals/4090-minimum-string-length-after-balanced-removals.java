class Solution {
    public int minLengthAfterRemovals(String s) {
        Stack<Character> s1 = new Stack<>();
        int i = 0;
        while(i<s.length()){
             if(!s1.isEmpty() && s1.peek()=='a' && s.charAt(i)=='b'){
                s1.pop();
            }
             else if(!s1.isEmpty() && s1.peek()=='b' && s.charAt(i)=='a'){
                s1.pop();
            }
            else{
                s1.push(s.charAt(i));
            }
             i++;
            }
            return s1.size();
    }
}