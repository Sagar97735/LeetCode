class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> h1 = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    String s = "(" + board[i][j] + ")";
                    if (!h1.add(s + i) || !h1.add(j + s) || !h1.add((i / 3) + s + (j / 3))) {
                        return false;
                    }
                }

            }
        }
        return true;
    }
}