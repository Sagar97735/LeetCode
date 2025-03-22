class Solution {
    public static void solve(String ans,  ArrayList<String> arr,HashMap<Character,String> map,String digits,int a){
        if(a==digits.length()){
            arr.add(ans);
            return;
        }
        String s = map.get(digits.charAt(a));
      for(int i = 0; i<s.length();i++){
            char c = s.charAt(i);
            solve(ans+c,arr,map,digits,a+1);
      }
     
         return;
    }
    public List<String> letterCombinations(String digits) {
     
        ArrayList<String> arr = new ArrayList<>();
           if (digits.isEmpty()) return arr;
        HashMap<Character,String> map = new HashMap<>(); 
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
           solve("",arr,map,digits,0);
           return arr;
    }
}