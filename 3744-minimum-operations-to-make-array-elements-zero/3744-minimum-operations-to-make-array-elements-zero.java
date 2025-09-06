class Solution {
    public long minOperations(int[][] queries) {
        long ans = 0;
        for(int i =0; i<queries.length; i++){
            int start = queries[i][0];
            int end = queries[i][1];
            long steps = getOperations(start, end);
            ans += ((steps+1)/2);
        }
        return ans;
    }
    public long getOperations(int start, int end){
            long operations = 0;
            long steps = 1;
            long low = 1;
            while(steps > 0){
                if(end<low){
                    break;
                }
                long high = 4*low -1;
                long l = Math.max(start,low);
                long r = Math.min(end,high);
                if(l<=r){
                    operations += (r-l+1)*steps;
                }
                steps++;
                low = low*4;
            }
            return operations;
    }
}