class Solution {
    public int maxOperations(String s) {
        int start = 0;
        int ans = 0;
        for(int i =0; i<s.length(); i++){
            if(s.charAt(i)=='1'){
                start = i;
                break;
            }
        }
        int zcnt = 0;
        boolean check = false;
        for(int i = start; i<s.length(); i++){
           if(s.charAt(i)=='0' && check == false){
            check = true;
            zcnt++;
           }
           else if(s.charAt(i)=='1'){
            check = false;
           }
        }
        check = false;
        for(int i = start; i<s.length(); i++){
            if(s.charAt(i)=='1'){
                ans+=zcnt;
                check =false;
            }
            else if(s.charAt(i)=='0' && check == false){
                zcnt-=1;
                check = true;
            }
        }
        return ans;
    }
}