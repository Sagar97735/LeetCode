class Solution {
    public int numberOfSubstrings(String s) {
        int [] arr = new int[3];
        int i = 0;
        int j = 0;
        int ans = 0;
        HashMap<Character,Integer> h1 = new HashMap<>();
        while(j<s.length()){
             h1.put(s.charAt(j),h1.getOrDefault(s.charAt(j),0)+1);

             while(h1.size()==3){
                    ans += (s.length()-j);
             h1.put(s.charAt(i),h1.get(s.charAt(i))-1);
             if(h1.get(s.charAt(i))==0){
                h1.remove(s.charAt(i));
             }
             i++;               
             }
             
                j++;
        }
      return ans;
    }
}