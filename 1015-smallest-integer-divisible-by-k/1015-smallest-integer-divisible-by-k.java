class Solution {
    public int smallestRepunitDivByK(int k) {
        if(k%2==0){
            return -1;
        }
        int length = 0;
        int mod = 1;
       
            for(int i = 0; i<k; i++){
            length = length+1;
            if(mod%k==0){
                return length;
            }
            mod = (mod%k)*10 +1;
            }
        
        return -1;
    }
}