//---------------------------------Recursive Approach<-----------------------------------------------------------------
import java.util.*;

public class Solution {
    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, Comparator.comparingInt(a -> a[0])); // sort by startDay

        return solve(events, 0, k);
    }

    private int solve(int[][] events, int i, int k) {
        if (k == 0 || i == events.length)
            return 0;

        // Linear search for next non-overlapping event
        int j = i + 1;
        while (j < events.length && events[j][0] <= events[i][1])
            j++;

        int take = events[i][2] + solve(events, j, k - 1);
        int skip = solve(events, i + 1, k);

        return Math.max(take, skip);
    }
}

//---------------------------------------------->Recursion + Memoization with Linear Search<------------------------------------------
import java.util.*;

public class Solution {
    int[][] dp;
    int n;

    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, Comparator.comparingInt(a -> a[0])); // sort by startDay

        n = events.length;
        dp = new int[n][k + 1];

        for (int[] row : dp)
            Arrays.fill(row, -1);

        return solve(events, 0, k);
    }

    private int solve(int[][] events, int i, int k) {
        if (k == 0 || i == n)
            return 0;

        if (dp[i][k] != -1)
            return dp[i][k];

        // Linear search for next non-overlapping event
        int j = i + 1;
        while (j < n && events[j][0] <= events[i][1])
            j++;

        int take = events[i][2] + solve(events, j, k - 1);
        int skip = solve(events, i + 1, k);

        return dp[i][k] = Math.max(take, skip);
    }
}
//--------------------------------------->Recursion + Memoization with Binary Search<----------------------------------------------------
import java.util.*;

public class Solution {
    int[][] dp;
    int n;

    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, Comparator.comparingInt(a -> a[0])); // sort by startDay

        n = events.length;
        dp = new int[n][k + 1];

        for (int[] row : dp)
            Arrays.fill(row, -1);

        return solve(events, 0, k);
    }

    private int solve(int[][] events, int i, int k) {
        if (k == 0 || i == n)
            return 0;

        if (dp[i][k] != -1)
            return dp[i][k];

        int next = findNextEvent(events, events[i][1]);
        int take = events[i][2] + solve(events, next, k - 1);
        int skip = solve(events, i + 1, k);

        return dp[i][k] = Math.max(take, skip);
    }

    // Binary search to find the first event that starts after current event ends
    private int findNextEvent(int[][] events, int currentEnd) {
        int low = 0, high = events.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (events[mid][0] > currentEnd)
                high = mid;
            else
                low = mid + 1;
        }
        return low;
    }
}

