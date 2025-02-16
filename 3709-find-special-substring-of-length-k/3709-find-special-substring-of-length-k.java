class Solution {
    public boolean hasSpecialSubstring(String s, int k) {
        int count = 1;
        Set<Integer> set = new HashSet<>();
        for(int i = 1; i < s.length(); i++) {
            char ch1 = s.charAt(i - 1);
            char ch2 = s.charAt(i);
            if(ch1 == ch2) count++;
            else {
                set.add(count);
                count = 1;
            }
        }
        set.add(count);
        return set.contains(k);
    }
}