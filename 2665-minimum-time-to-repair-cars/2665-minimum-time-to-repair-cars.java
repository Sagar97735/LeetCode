class Solution {
    public boolean ispossible(int[] ranks,long time,int cars){
       long totalCars = 0;
       int i = 0;
       while(i<ranks.length){
        totalCars += Math.sqrt(time/ranks[i]);
        if(totalCars >= cars){
            return true;
        }
        i++;
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