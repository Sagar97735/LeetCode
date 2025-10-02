class Solution {
    public int[] decimalRepresentation(int n) {
        String s = "";
        s+=n;
        int size = s.length();
        for(int i =0; i<s.length(); i++){
            if(s.charAt(i)=='0'){
             size--;
            }
        }
        int add = 1;
        int [] arr = new int[size];
        int i = arr.length-1;
        while(i>=0){
            int num = (n%10);
            n/=10;
            num = num*add;
            if(num==0){
                add*=10;
            }
           else{
            arr[i] = num;
            add*=10;
            i--;
           }
        }
        return arr;
    }
}