class Solution {
    public void union(String s1, String s2, HashMap<String, String> parent) {
        String s1_parent = find(s1, parent);
        String s2_parent = find(s2, parent);
        if (s1_parent != s2_parent) {
            parent.put(s2_parent, s1_parent);
        }
    }

    public String find(String s1, HashMap<String, String> parent) {
        if (s1.equals(parent.get(s1))) {
            return s1;
        }
        String res = find(parent.get(s1), parent);
        parent.put(s1, res); // path compression
        return res;
    }

    public boolean check(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        for (int i = 0; i < str1.length(); i++) {
            if (str2.indexOf(str1.charAt(i)) < 0) {
                return false;
            }
        }
        int cnt = 0;
        for (int i = 0; i < str1.length(); i++) {
            char a = str1.charAt(i);
            char b = str2.charAt(i);
            if (a != b) {
                cnt++;
            }
            if (cnt > 2) {
                return false;
            }
        }
        return true;
    }

    public int numSimilarGroups(String[] strs) {
        HashMap<String, String> parent = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            parent.put(strs[i], strs[i]);
        }
        for (int i = 0; i < strs.length; i++) {
            for (int j = i + 1; j < strs.length; j++) {
                if (check(strs[i], strs[j])) {
                    union(strs[i], strs[j], parent);
                }
            }
        }
        HashSet<String> h1 = new HashSet<>();
        for (int i = 0; i < strs.length; i++) {
            String par = find(strs[i], parent);
            h1.add(par);
        }
        return h1.size();
    }
}