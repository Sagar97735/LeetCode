class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLen = 0;

        for (int i = 0; i < n; i++) {  // Start index
            Set<Character> seen = new HashSet<>();
            for (int j = i; j < n; j++) {  // End index
                char c = s.charAt(j);
                if (seen.contains(c)) {
                    break;  // Stop if duplicate found
                }
                seen.add(c);
                maxLen = Math.max(maxLen,seen.size());
            }
        }

        return maxLen;
    }
}
