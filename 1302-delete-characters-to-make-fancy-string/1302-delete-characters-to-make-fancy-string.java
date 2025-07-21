class Solution {
    public String makeFancyString(String s) {
        StringBuilder str = new StringBuilder();
        if(s.length()==1){
            return s;
        }
        str.append(s.charAt(0));
        str.append(s.charAt(1));
        for(int i =2; i<s.length(); i++){
         if(s.charAt(i)==s.charAt(i-1) && s.charAt(i-1)==s.charAt(i-2)){
            continue;
         }
         str.append(s.charAt(i));
        }
        return str.toString();
    }
}