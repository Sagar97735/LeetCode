class Solution {
    public String removeStars(String s) {
        Stack<Character> s1 = new Stack<>();
        String str = "";
        int i = 0;
        while(i<s.length()){
            s1.push(s.charAt(i));
            i++;
            if(s1.peek()=='*'){
                s1.pop();
                s1.pop();
            }
        }
        while(!s1.isEmpty()){
            str+=s1.pop();
        }
        String str1 = "";
        for(int j = str.length()-1; j>=0; j--){
        str1+= str.charAt(j);
    }
    return str1;
    }
}