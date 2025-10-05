class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> arr = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        
        int start = intervals[0][0];
        int end = intervals[0][1];
        
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= end) {
                end = Math.max(end, intervals[i][1]); // merge overlapping
            } else {
                arr.add(new int[]{start, end}); // add previous merged
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        
        // Add the last interval
        arr.add(new int[]{start, end});
        
        // Convert List<int[]> to int[][]
        return arr.toArray(new int[arr.size()][]);
    }
}
