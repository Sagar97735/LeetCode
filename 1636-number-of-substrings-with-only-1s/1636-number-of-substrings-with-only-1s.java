class Solution {
    public int numSub(String s) {
        int mod = 1000000000+7;
        int cnt = 0;
        int start = Integer.MAX_VALUE;
        int end = 0;
        int i = 0;
        while(i<s.length()){
            if(s.charAt(i)=='1'){
                end = Math.max(end,i);
                start = Math.min(start,i);
               
            }
           else if(s.charAt(i)=='0' && start<s.length()){
             int n = (end-start)+1;
             for(int j = n; j>=1; j--){
                cnt = (cnt + j) % mod;
             }
             start = Integer.MAX_VALUE;
             end = 0;
            }
            i++;
        }
        if(s.charAt(s.length()-1)=='1'){
             int n = (end-start)+1;
            for(int j = n; j>=1; j--){
               cnt = (cnt + j) % mod;
             }
        }
        return cnt;
    }
}