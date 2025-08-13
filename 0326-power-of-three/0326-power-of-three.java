class Solution {
    public boolean isPowerOfThree(int n) {
       if(n==1){
           return true;
       }
       if(n<1||n%2==0||n%3==2){
           return false;
       } 
       return isPowerOfThree(n/3);
    }
}
// class Solution {
//     public boolean isPowerOfThree(int n) {
//         return n > 0 && 1162261467 % n == 0;
//     }
// }
