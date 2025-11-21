class Solution {
    public int countPalindromicSubsequence(String s) {

        int n = s.length();
        int ans = 0;

        // For each character from 'a' to 'z'
        for (char c = 'a'; c <= 'z'; c++) {
            int left = -1, right = -1;

            // Find first and last occurrence
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == c) {
                    if (left == -1) left = i;
                    right = i;
                }
            }

            // if not enough space for mid character → skip
            if (left != -1 && right != -1 && right - left >= 2) {

                boolean[] seen = new boolean[26];

                // count unique mid characters
                for (int mid = left + 1; mid < right; mid++) {
                    seen[s.charAt(mid) - 'a'] = true;
                }

                // add count of true values
                for (int k = 0; k < 26; k++) {
                    if (seen[k]) ans++;
                }
            }
        }

        return ans;
    }
}
