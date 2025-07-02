class Solution {
    public List<Integer> findAnagrams(String s, String p) {
           List<Integer> arr = new ArrayList<>();
         if (s.length() < p.length()) return arr;
        int [] pfreq = new int[26];
        int [] windowfreq = new int[26];
        int n1 = s.length();
        for(int i =0; i<p.length(); i++){
            char c = p.charAt(i);
            pfreq[c-'a']++;
        }
        int n = p.length();
        for(int i = 0; i<n; i++){
            char c = s.charAt(i);
            windowfreq[c-'a']++;
        }
  if(Arrays.equals(pfreq,windowfreq)){
          arr.add(0);
  }
  int k = p.length();
   for (int i = 1; i <= s.length() - p.length(); i++){
     // Remove the leftmost char of previous window
            windowfreq[s.charAt(i - 1) - 'a']--;
            // Add the new char to the right of current window
            windowfreq[s.charAt(i + n - 1) - 'a']++;

    if(Arrays.equals(pfreq,windowfreq)){
    arr.add(i);
  }
   }
   return arr;
    }
}