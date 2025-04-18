class Solution {
    public String isSolve(String s){
        int cnt =0;
        String ans = "";
        int i =0;
        Stack<Character> s1 = new Stack<>();
        while(i<=s.length()){
            if(i==s.length()){
           ans+=cnt;
           if(!s1.isEmpty()){
            ans+=s1.peek();
           }
           s1.clear();
           cnt =0;
           i++;
            }
          else if(s1.isEmpty()||s1.peek()==s.charAt(i)){
          s1.push(s.charAt(i));
          cnt++;
          i++;
        }
          else if(i==s.length() || s1.peek()!=s.charAt(i)){
           ans+=cnt;
           ans+=s1.peek();
           s1.clear();
           cnt =0;
          }
          
    }
    return ans;
    }
    public String countAndSay(int n) {
        if(n==1){
            return "1";
        }
        String s = "11";
        if(n==2){
            return s;
        }
       
              while(n>=3){
                String temp = isSolve(s);
                s = temp;
                n--;
              }
       
       return s;
}
}