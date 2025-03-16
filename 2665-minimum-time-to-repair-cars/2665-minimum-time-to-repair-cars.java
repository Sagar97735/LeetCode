class Solution {
    public boolean ispossible(int[] ranks,long mid,long cars){
       long c = 1;
       int i = 0;
       long ans = 0;
       while(i<ranks.length){
        int b = ranks[i];
        if((b*c*c)<=mid){
            c++;
        }
        else{
            ans+=(c-1);
            i++;
            c=1;
        }
        if(ans>=cars){
            return true;
        }
       }
       return false;
    }
    public long repairCars(int[] ranks, int cars) {
        int min = Arrays.stream(ranks).min().getAsInt();
        long start = 1;
        long end = min * (long)cars*cars;
        while(start<end){
            long mid = (start+end)/2;
            if(ispossible(ranks,mid,cars)){
                end = mid;
            }
            else{
                start = mid+1;
            }
        }
        return start;
    }
}