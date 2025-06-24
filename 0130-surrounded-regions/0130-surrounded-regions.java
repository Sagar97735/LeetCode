class Solution {
    int temp = 0;
    public void isSolve(boolean[][] visited, char[][] board, int i, int j) {
        if ( i >= board.length || j >= board[0].length || i < 0 || j < 0||visited[i][j]) {
            return;
        }
        if (board[i][j] == 'O') {
            visited[i][j] = true;
            isSolve(visited, board, i, j - 1);
            isSolve(visited, board, i + 1, j);
            isSolve(visited, board, i, j + 1);
            isSolve(visited, board, i - 1, j);
        }
       
        return;
    }
    
    public void solve(char[][] board) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j]=='O' &&( i==0 || j==0 || i==board.length-1 || j== board[0].length-1)) {
                    isSolve(visited, board, i, j);
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (!visited[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }

    }
}

