class Solution {
    private Map<Integer, Long> memo;

    public long isSolve(int[][] arr, int i) {
        if (i >= arr.length) {
            return 0;
        }
        if (memo.containsKey(i)) {
            return memo.get(i);
        }
        
        int pts = arr[i][0];
        int skip = arr[i][1];
        long include = pts + isSolve(arr, i + skip + 1);
        long exclude = isSolve(arr, i + 1);
        
        long result = Math.max(include, exclude);
        memo.put(i, result);
        
        return result;
    }
    
    public long mostPoints(int[][] questions) {
        memo = new HashMap<>();
        return isSolve(questions, 0);
    }
}
