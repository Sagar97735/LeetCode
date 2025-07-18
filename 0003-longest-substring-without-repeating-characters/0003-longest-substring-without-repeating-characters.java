class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start = 0;
        int end = 0;
        int max = 0;
        ArrayList<Character> arr = new ArrayList<>();
        while(end<s.length()){
         if(!(arr.contains(s.charAt(end)))){
             arr.add(s.charAt(end));
             end++;
             max = Math.max(max,arr.size());
         }
         else{
             arr.remove(Character.valueOf(s.charAt(start)));
             start++;
         }
        }
        return max;
    }
}