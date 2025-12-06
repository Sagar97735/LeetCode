class Solution {
    public int minimumRecolors(String blocks, int k) {
        int i = 0;
        int cnt = 0;
        int req = blocks.length();
        for(int j = 0; j<k; j++){
            if(blocks.charAt(j)=='W'){
                cnt++;
            }
        }
        int j = k;
        req = Math.min(req,cnt);
        while(j<blocks.length()){
            if(blocks.charAt(i)=='W'){
                cnt--;
            }
            if(blocks.charAt(j)=='W'){
                cnt++;
            }
            i++;
            j++;
             req = Math.min(req,cnt);
        }
        return req;
    }
}