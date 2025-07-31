import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        if (arr == null || arr.length == 0) return 0;

        Set<Integer> result = new HashSet<>();
        Set<Integer> prev = new HashSet<>();

        for (int a : arr) {
            Set<Integer> cur = new HashSet<>();
            // Start a new subarray at this element
            cur.add(a);
            // Extend all subarrays that ended at the previous index
            for (int v : prev) {
                cur.add(v | a);
            }
            // Add to the global set and advance
            result.addAll(cur);
            prev = cur;
        }
        return result.size();
    }
}
