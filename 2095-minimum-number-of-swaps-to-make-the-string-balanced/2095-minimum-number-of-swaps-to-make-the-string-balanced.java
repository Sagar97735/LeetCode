class Solution {
    public int minSwaps(String s) {
        int count = 0;
        Stack<Character> s1 = new Stack<>();
        for(int i = 0; i<s.length(); i++){
              if(s.charAt(i)=='['){
                s1.push(s.charAt(i));
              }
            else if(s1.size()!=0 && s.charAt(i)==']'){
                  s1.pop();
            }
            else{
                count++;
            }
        }
        int ans = (count+1)/2 ;
        return ans;
    }
}