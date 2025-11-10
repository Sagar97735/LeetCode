class Solution {
    public int minOperations(int[] nums) {
        int cnt = 0;
        TreeSet<Integer> active = new TreeSet<>();

        for (int x : nums) {
            if (x == 0) {
                active.clear(); 
                continue;
            }

            // Remove all elements > x
            active.tailSet(x+1).clear();

            if (!active.contains(x)) {
                cnt++;
                active.add(x);
            }
        }

        return cnt;
    }
}
