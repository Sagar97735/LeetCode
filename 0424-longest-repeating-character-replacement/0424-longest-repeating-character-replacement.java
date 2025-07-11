class Solution {
    public int characterReplacement(String s, int k) {
        int i=0; int j=0; int max = Integer.MIN_VALUE; int freq = 0;
        Map<Character, Integer> map = new HashMap<>();
        while(j<s.length()){
            char c = s.charAt(j);
            map.put(c, map.getOrDefault(c, 0)+1);
            freq = Math.max(map.get(c), freq);
            while((j-i+1) - freq > k){
                map.put(s.charAt(i), map.get(s.charAt(i))-1);
                if(map.get(s.charAt(i)) == 0){
                    map.remove(s.charAt(i));
                }
                i++;
            }
            max = Math.max(max, j-i+1);
            j++;
        }
        return max;
    }
}