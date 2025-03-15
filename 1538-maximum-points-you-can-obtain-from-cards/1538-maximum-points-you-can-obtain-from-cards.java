class Solution {
    public int maxScore(int[] cardPoints, int k) {
    int max = 0;
     for(int i = 0; i<cardPoints.length; i++){
       max+=cardPoints[i];
     }
     int size = cardPoints.length - k;
     int j = 0;
     int sum = 0;
     int ans = 0;
     int i =0;
     while(j<size){
           sum+=cardPoints[j];
           j++;
     }
     ans = Math.max(ans,max-sum);
     while(j<cardPoints.length){
             sum+=cardPoints[j];
             sum-=cardPoints[i];
             ans = Math.max(ans,max-sum);
             j++;
             i++;
     }
        return ans;
    }
}