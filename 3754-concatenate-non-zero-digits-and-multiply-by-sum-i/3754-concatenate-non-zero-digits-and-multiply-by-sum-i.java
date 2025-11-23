class Solution {
    public long sumAndMultiply(int n) {
        long sum = 0;
        StringBuilder sb = new StringBuilder();
        while(n>0){
            int last = n%10;
            n = n/10;
            sum+=last;
            if(last>0){
                sb.append(last);
            }
        }
        sb.reverse();
        if(sum==0){
            return 0;
        }
        int num = Integer.parseInt(sb.toString());
        return num*sum;
    }
}