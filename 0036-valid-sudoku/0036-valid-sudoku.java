class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> h1 = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
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