class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        int i = 0;
        int cnt = 0;
        int notwork = 0;
        int ans = 0;
        while(i<text.length()){
            if(text.charAt(i)==' '){
                cnt++;
            }
            if(brokenLetters.indexOf(text.charAt(i))>=0){
                notwork++;
                while( i<text.length() && text.charAt(i)!=' '){
                    i++;
                }
            }
            else{
                i++;
            }
        }
        cnt = cnt+1;
        return cnt-notwork;
    }
}