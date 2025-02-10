class Solution {
    public String clearDigits(String s) {
        Stack<Character> s1 = new Stack<>();
        HashSet <Character> h1 = new HashSet<>();
        for(char i ='0'; i<='9';i++){
            h1.add(i);
        }
        String s2 = "";
        String ans = "";
        for(int i =0; i<s.length(); i++){
            if(h1.contains(s.charAt(i))){
                s1.pop();
            }
           else{
            s1.push(s.charAt(i));
           }
        }
    while(!s1.isEmpty()){
        s2 += s1.pop();
    }
    for(int i=s2.length()-1;i>=0; i--){
       ans+=s2.charAt(i);
    }
    return ans;
    }
}