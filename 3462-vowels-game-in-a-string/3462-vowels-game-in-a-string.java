class Solution {
    public boolean doesAliceWin(String s) {
     int cnt = 0;
     String vowels = "aeiou";
     int turn = 0;
     int vow =0;
     int con = 0;
     for(int i =0; i<s.length(); i++){
         if(vowels.indexOf(s.charAt(i))>=0){
                vow++;
            }
     }
     con = s.length()-vow;
       if(vow!=0 ){
        return true;
       }
       return false;
    }
}