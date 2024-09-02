class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character,Integer> h1 = new HashMap<>();
        for(int i = 0; i<s.length(); i++){
            if(h1.containsKey(s.charAt(i))){
                int a = h1.get(s.charAt(i)) + 1;
                h1.put(s.charAt(i),a);
            }
            else{
                h1.put(s.charAt(i),1);
            }
        }
        char ans = '0';
        int i = 0;
        while(i<s.length()){
             if(h1.get(s.charAt(i))==1){
                return i;
             }
             else{
                i++;
             }
        }
        return -1;
    }
}