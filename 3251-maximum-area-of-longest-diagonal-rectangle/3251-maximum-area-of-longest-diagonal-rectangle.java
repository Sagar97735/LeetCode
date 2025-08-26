class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int maxDiagonal = -1;
        int maxArea = -1;

        for (int[] rect : dimensions) {
            int l = rect[0];
            int w = rect[1];

            int diagonalSq = l * l + w * w; // no need sqrt
            int area = l * w;

            if (diagonalSq > maxDiagonal) {
                maxDiagonal = diagonalSq;
                maxArea = area;
            } else if (diagonalSq == maxDiagonal) {
                maxArea = Math.max(maxArea, area);
            }
        }

        return maxArea;
    }
}
