class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int count = 0;
        int a = 0;
        int b = 0;
        for(int i = 0;i<s1.length();i++){
           if(s1.charAt(i)!=s2.charAt(i)){
             if(count>2){
            return false;
           }
            else if(a==0){
                a = i;
                count++;
            }
            else if(b==0){
                b = i;
                count++;
            }
           }
        }
        String s3 = "";
        if(count==2){
            for(int i =0; i<s1.length();i++){
                if(i==a){
                    s3+=s2.charAt(b);
                }
                else if(i==b){
                     s3+=s2.charAt(a);
                }
                else{
                s3+=s2.charAt(i);
            }}
        }
         if(s1.equals(s3)||count==0){
            return true;
        }
       return false;
    }
}