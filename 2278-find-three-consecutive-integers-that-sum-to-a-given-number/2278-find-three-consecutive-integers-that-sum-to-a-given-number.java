class Solution {
    public long[] sumOfThree(long num) {
        long [] ans = new long[3];
        long n = num/3;
       long start = -50;
       long end = n;
       while(start<end){
        long mid = start + (end - start) / 2;
        long curr = mid+mid+1+mid+2;
        if(curr<num){
            start = mid+1;
        }
        else if(curr>num){
            end = mid-1;
        }
        else{
            ans[0] = mid;
            ans[1] = mid+1;
            ans[2] = mid+2;
            return ans;
        }
       }
        return new long[0];
    }
}