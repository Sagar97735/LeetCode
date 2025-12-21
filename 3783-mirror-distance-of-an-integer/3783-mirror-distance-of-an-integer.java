class Solution {
    public int mirrorDistance(int n) {
        StringBuilder s = new StringBuilder();
        int num = n;
        int ans = 0;
        while(num>0){  
            int a = num%10;
            s.append(a);
            num/=10;
        }
int a = Integer.valueOf(s.toString());
        return Math.abs(a-n);
    }
}