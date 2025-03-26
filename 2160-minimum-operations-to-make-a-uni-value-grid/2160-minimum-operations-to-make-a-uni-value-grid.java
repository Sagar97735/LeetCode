import java.util.*;

class Solution {
    public int minOperations(int[][] grid, int x) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int[] row : grid) {
            for (int num : row) {
                list.add(num);
            }
        }

        Collections.sort(list);
        int median = list.get(list.size() / 2);

        int operations = 0;
        for (int num : list) {
            int diff = Math.abs(num - median);
            if (diff % x != 0) return -1;  // If transformation is impossible
            operations += (diff / x);
        }

        return operations;
    }
}
