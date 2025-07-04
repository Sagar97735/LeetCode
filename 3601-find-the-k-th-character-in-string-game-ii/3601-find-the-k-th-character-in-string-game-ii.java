class Solution {
    public char kthCharacter(long k, int[] operations) {
        if(k==1){
            return 'a';
        }
        int n = operations.length;
        long len = 1;
        int type = 0;
        long k1 = 0;
        for(int i =0; i<n; i++){
            len = len*2;
            if(len>=k){
                type = operations[i];
                k1 = k-(len/2);
                break;
            }
        }
       char c = kthCharacter(k1,operations);
        if(type == 0){
            return c;
        }
        if(c=='z'){
            return 'a';
        }
        return (char)(c+1);
    }
}