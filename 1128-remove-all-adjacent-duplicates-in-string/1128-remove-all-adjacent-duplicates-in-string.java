class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> s1 = new Stack<>();
        for(int i =0; i<s.length(); i++){
             if(s1.isEmpty()){
                s1.push(s.charAt(i));
             }
             else{
                if(s1.peek()==s.charAt(i)){
                    s1.pop();
                }
                else{
                    s1.push(s.charAt(i));
                }
             }
        }
    String ans = "";
    String ans1 = "";
    while(!s1.isEmpty()){
        char c = s1.pop();
        ans+=c;
    }
    for(int i = ans.length()-1; i>=0; i--){
        ans1+=ans.charAt(i);
    }
     return ans1;
    }
}