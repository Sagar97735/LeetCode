class Solution {
    public long countOfSubstrings(String word, int k) {
        int[] arr = new int[26];
        String vowel = "aeiou";
        int[] next = new int[word.length()];
        next[word.length() - 1] = word.length();
        int lastidx = next.length;
        for (int i = next.length - 1; i >= 0; i--) {
            next[i] = lastidx;
            if (vowel.indexOf(word.charAt(i)) < 0) {
                lastidx = i;
            }
        }
        int i = 0;
        int j = 0;
        int conso = 0;
        long ans = 0;

        while (j < word.length()) {
            char c = word.charAt(j);
            arr[c - 'a']++;
            if (vowel.indexOf(c) < 0) {
                conso++;
            }
            if (arr['a' - 'a'] > 0 && arr['e' - 'a'] > 0 && arr['i' - 'a'] > 0 && arr['o' - 'a'] > 0
                    && arr['u' - 'a'] > 0 && conso >= k) {

                while (arr['a' - 'a'] > 0 && arr['e' - 'a'] > 0 && arr['i' - 'a'] > 0 && arr['o' - 'a'] > 0
                        && arr['u' - 'a'] > 0 && conso >= k) {
                    if (arr['a' - 'a'] > 0 && arr['e' - 'a'] > 0 && arr['i' - 'a'] > 0 && arr['o' - 'a'] > 0
                            && arr['u' - 'a'] > 0 && conso == k) {
                        ans += (next[j] - j);
                    }
                    arr[word.charAt(i) - 'a']--;
                    if (vowel.indexOf(word.charAt(i)) < 0) {
                        conso--;
                    }
                    i++;
                }
            }

            j++;
        }
        return ans;
    }
}