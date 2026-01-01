class Solution {
    public int minAllOneMultiple(int k) {
        if(k%2==0 || k%5==0){
            return -1;
        }
        int ans = 2;
        long val = 11;
        while(val%k!=0){
            val = val%k;
            val = (val*10)+1;
            ans+=1;
        }
        return ans;
    }
}