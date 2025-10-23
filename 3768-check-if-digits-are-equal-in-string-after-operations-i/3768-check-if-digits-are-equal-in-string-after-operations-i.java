class Solution {
    public boolean hasSameDigits(String s) {
        StringBuilder str = new StringBuilder();
        str.append(s);
        while(str.length()>2){
            StringBuilder s1 = new StringBuilder();
          for(int i=0; i<str.length()-1; i++){
            int a = str.charAt(i) - '0';
            int b = str.charAt(i+1) - '0';
            int c = (a+b)%10;
            s1.append(c);
          }
          str = s1;
        }
        if(str.length()==2 && str.charAt(0)==str.charAt(1)){
            return true;
        }
        return false;
    }
}