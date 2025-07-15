class Solution {
    public boolean isValid(String word) {
        if(word.length()<3){
            return false;
        }
        if(word.indexOf('@')>=0 || word.indexOf('#')>=0 || word.indexOf('$')>=0 ){
            return false;
        }
        String vowel = "aeiouAEIOU";
        String nums = "0123456789";
        boolean v = false;
        boolean cons = false;
        boolean num = false;
        for(int i = 0; i<word.length(); i++){
            if(vowel.indexOf(word.charAt(i))>=0){
                 v = true;
            }
            else if(vowel.indexOf(word.charAt(i))<0 && nums.indexOf(word.charAt(i))<0){
                 cons = true;
            }
            if(v==true && cons== true){
                return true;
            }
        }
        if(v==true && cons== true && num == true){
                return true;
            }
            return false;
    }
}