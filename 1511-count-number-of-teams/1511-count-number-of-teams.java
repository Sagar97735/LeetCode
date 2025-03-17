class Solution {
    public int numTeams(int[] rating) {
        int n=rating.length;
        
        int total=0;
        for(int i=1;i<n-1;i++){
            int leftless=0; // for accending pattern
            int rightgreater=0; // for accending pattern
            
            int leftgreater=0; // for descending pattern
            int rightless=0;  //for descending pattern
            
            for(int j=i-1;j>=0;j--){
                if(rating[i]>rating[j]){
                    leftless++;
                }
                else{
                    leftgreater++;
                }
            }
            for(int j=i+1;j<n;j++){
                if(rating[i]>rating[j]){
                    rightless++;
                }else{
                    rightgreater++;
                }
            }
            total+= leftless*rightgreater + rightless*leftgreater; // no of counts possible from the ith index.
        }
        return total;
    }
}