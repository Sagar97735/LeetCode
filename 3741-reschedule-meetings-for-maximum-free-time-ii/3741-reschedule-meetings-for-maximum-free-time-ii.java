class Solution {
    public int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
        int n = startTime.length;
       int [] gap = new int[startTime.length +1];
       gap[0] = startTime[0];
       gap[n] = eventTime - endTime[n-1];
       for(int i =1; i<n; i++){
        gap[i] = startTime[i]-endTime[i-1];
       }
      int [] suffix = new int[gap.length];
      int [] prefix = new int[gap.length];
      prefix[0] = 0;
      suffix[n] = 0;
      for(int i =1; i<prefix.length; i++){
       prefix[i] = Math.max(gap[i-1],prefix[i-1]);
      }
      for(int i =n-1; i>=0; i--){
       suffix[i] = Math.max(gap[i+1],suffix[i+1]);
      }
       int i = 0;
       int j = 1;
       int currtime =0;
       int maxtime = 0;
       while(j<gap.length){
        currtime=0;
        currtime+=gap[i];
        currtime+=gap[j];
        if(currtime>maxtime){
            maxtime = currtime;
        }
        int extra = endTime[i] - startTime[i];
        if(prefix[i]>=extra || suffix[j]>=extra ){
            currtime+=extra;
            if(currtime>maxtime){
            maxtime = currtime;
        }
        }
       i++;
       j++;
    }
       return maxtime;
    }
}