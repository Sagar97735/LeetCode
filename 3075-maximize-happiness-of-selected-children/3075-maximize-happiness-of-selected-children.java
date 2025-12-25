class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
       if(happiness.length<k){
        return -1;
       }
       Arrays.sort(happiness);
        long sum = 0;
        long j =k-1;
        int i =happiness.length -k;
        while(i<=happiness.length-1 && j>=0){
           happiness[i]-=j;
           if(happiness[i]<0){
            happiness[i] = 0;
           }
           sum+=happiness[i];
           i++;
           j--;
        }
        return sum;
    }
}