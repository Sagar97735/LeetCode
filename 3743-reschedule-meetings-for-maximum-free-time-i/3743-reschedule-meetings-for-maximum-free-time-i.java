class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int n = startTime.length;
        if(k>=n){
             int total = 0;
             for(int i =0; i<n; i++){
               total += (endTime[i]-startTime[i]);
             }
             return eventTime - total;
        }
        int [] gap = new int[n+1];
        gap[0] = startTime[0];
        for(int i =1; i<startTime.length; i++){
            gap[i] = startTime[i] - endTime[i-1];
        }
        gap[n] = eventTime - endTime[n-1];
        int currtime =0;
        int maxtime = 0;
        for(int i =0; i<k+1; i++){
            currtime+=gap[i];
        }
        maxtime = currtime;
        int i =0; 
        int j = k+1;
        while(j<gap.length){
            currtime-= gap[i];
            currtime += gap[j];
            if(maxtime<currtime){
                maxtime = currtime;
            }
            i++;
            j++;
        }
        return maxtime;
    }
}