class Solution {
    public String largestGoodInteger(String num) {
        String ans = "";
        int a1 = -1;
        for(int i =0; i<num.length()-2; i++){
            if(num.charAt(i)==num.charAt(i+1) && num.charAt(i+1)==num.charAt(i+2)){
                int a = Integer.valueOf(String.valueOf(num.charAt(i)));
                a1 = Math.max(a1,a);
            }
        }
        if(a1==-1){
            return ans;
        }
        ans+=a1;
        ans+=a1;
        ans+=a1;
        return ans;
    }
}