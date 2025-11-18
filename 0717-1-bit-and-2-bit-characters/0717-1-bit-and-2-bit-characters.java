class Solution {
    public boolean isOneBitCharacter(int[] bits) {
       int i =0;
       while(i<bits.length){
        if(bits[i]==1){
            i=i+2;
        }
        else if(i==bits.length-1 && bits[i]==0){
            return true;
        }
        else{
               i++;
        }
        
       } 
       return false;
    }
}