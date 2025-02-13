class Solution {
    public void solve(String ans, int l1,int l2,List<String> arr){
        if(l1==0 && l2==0){
            arr.add(ans);
        }
      if (l1 > 0) {
            solve(ans + '(', l1 - 1, l2, arr);
        }
      if (l2 > l1) {
            solve(ans + ')', l1, l2 - 1, arr);
        }
   return;
    }
    public List<String> generateParenthesis(int n) {
       List<String> arr = new ArrayList<>();
       solve("",n,n,arr); 
          return arr; 
    }
}