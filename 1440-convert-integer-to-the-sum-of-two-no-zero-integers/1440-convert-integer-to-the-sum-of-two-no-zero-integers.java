class Solution {
    public int[] getNoZeroIntegers(int n) {
        int [] arr = new int[2];
        for(int i = 0; i<n; i++){
            String s1 = "";
            String s2 = "";
            s1+=i;
            s2+=(n-i);
            if(s1.indexOf('0')<0 && s2.indexOf('0')<0){
                arr[0] = i;
                arr[1] = n-i;
                return arr;
            }
        }
        return arr;
    }
}