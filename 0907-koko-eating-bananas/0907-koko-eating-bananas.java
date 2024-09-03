class Solution {
    public static boolean valid_ans(int mid,int [] piles, int h){
            int a = 0;
            for(int i = 0; i< piles.length; i++){
                if(piles[i]<mid){
                    a+= 1;
                }
              else{
                a+=piles[i]/mid;
                if(piles[i]%mid!=0){
                a+=1;
              }
                }
                if(a>h){
            return false;
        }
              
            }
        
        return true;
        }
    public int minEatingSpeed(int[] piles, int h) {
        int start = 1;
        int end = Integer.MIN_VALUE;
        for(int i = 0; i<piles.length; i++){
            if(end<piles[i]){
                end = piles[i];
            }
        }
        int ans =-1;
        while(start<=end){
             int mid = start + (end-start)/2 ;
              if(valid_ans(mid,piles,h)){
                ans = mid;
                end = mid-1;
              }
              else{
                start = mid +1;
              }
        }
        return ans; 
    }
}