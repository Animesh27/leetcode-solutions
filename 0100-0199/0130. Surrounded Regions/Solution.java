class Solution {

    int[] dr = {-1, 0, 0, 1};
    int[] dc = {0, -1, 1, 0};
    public boolean isSafe(int r, int c, int R, int C){
        return r>=0 && r<R && c>=0 && c<C;
    }

    private void boundaryDFS(char[][] board, int i, int j) {
        if (!isSafe(i, j, board.length, board[0].length))
            return;
        board[i][j] = '*';
        for(int k = 0;k<4;k++){
            int r = i + dr[k];
            int c = j + dc[k];
            if(isSafe(r,c, board.length, board[0].length) && board[r][c] == 'O'){
                boundaryDFS(board, r, c);
            }
        }
    }
    public void solve(char[][] board) {
        if (board.length == 0 || board[0].length == 0)
            return;
        if (board.length < 2 || board[0].length < 2)
            return;
        int m = board.length;
        int n = board[0].length;
        for(int i = 0;i<m;i++){
            if(board[i][0] == 'O'){
                boundaryDFS(board, i, 0);
            }
            if(board[i][n-1] == 'O'){
                boundaryDFS(board, i, n-1);
            }
        }

        for(int i = 0;i<n;i++){
            if(board[0][i] == 'O'){
                boundaryDFS(board, 0, i);
            }
            if(board[m-1][i] == 'O'){
                boundaryDFS(board, m-1, i);
            }
        }

        //post-prcessing, turn 'O' to 'X', '*' back to 'O', keep 'X' intact.
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                else if (board[i][j] == '*')
                    board[i][j] = 'O';
            }
        }
    }
}