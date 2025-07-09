class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int n = startTime.length;
        if(k>=n){
            int total =0;
            for(int i=0; i<n; i++){
                total+=(endTime[i]-startTime[i]);
            }
            return eventTime-total;
        }
        int [] freetime = new int[n+1];
        freetime[0] = startTime[0];
        for(int i=1;i<startTime.length; i++){
            freetime[i] = startTime[i] - endTime[i-1];
        }
        freetime[n] = eventTime - endTime[n-1];
        int currtime = 0;
        int maxtime = 0;
        for(int i =0; i<k+1; i++){
            currtime += freetime[i];
          
        }
        maxtime = currtime;
        int i =0;
        int j = k+1;
        while(j<freetime.length){
            currtime-=freetime[i];
            currtime+=freetime[j];
            if(currtime>maxtime){
                maxtime = currtime;
            }
            i++;
            j++;
        }
        return maxtime;
       
    }
}