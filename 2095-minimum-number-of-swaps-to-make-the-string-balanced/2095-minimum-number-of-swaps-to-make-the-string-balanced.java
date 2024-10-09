class Solution {
    public int minSwaps(String s) {
        int count = 0;
        int size = 0;
        for(int i = 0; i<s.length(); i++){
              if(s.charAt(i)=='['){
                size++;
              }
            else if(size>0 && s.charAt(i)==']'){
                  size--;
            }
            
        }
        int ans = (size+1)/2 ;
        return ans;
    }
}