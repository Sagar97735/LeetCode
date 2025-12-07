class Solution {
    public int countOdds(int low, int high) {
        
        int num1 = 1;
        int num2 = 1;
        if(low%2==0){
            num1 = 0;
        }
        if(high%2==0){
            num2 = 0;
        }
        int diff = (high-low);
        if(num1==1 && num2==1){
            return (diff/2)+1;
        }
        if(num1==0 && num2==0){
            return diff/2;
        }
         return (diff+1)/2 ;
    }
}