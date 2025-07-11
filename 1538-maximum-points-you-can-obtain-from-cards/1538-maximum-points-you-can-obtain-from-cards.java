class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int max = 0;
        for(int i =0; i<cardPoints.length; i++){
            max+=cardPoints[i];
        }
        int size = cardPoints.length-k;
        int i =0;
        int sum = 0;
        int ans = Integer.MAX_VALUE;
        for(int j =0; j<size; j++){
            sum+=cardPoints[j];
        }
        ans= Math.min(ans,sum);
        int j = size;
        while(j<cardPoints.length){
           sum-=cardPoints[i];
           sum+=cardPoints[j];
           i++;
           j++;
          ans= Math.min(ans,sum);
        }
        return max-ans;
    }
}