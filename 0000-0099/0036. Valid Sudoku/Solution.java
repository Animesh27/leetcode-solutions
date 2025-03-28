class Solution {
    public boolean isValidSudoku(char[][] board, int row, int col, char c){
        for(int i = 0;i<9;i++){
            if(i != row && board[i][col] != '.' && board[i][col] == c)return false;
            if(i != col && board[row][i] != '.' && board[row][i] == c)return false;
            int rowIndex= 3*(row/3)+i/3;
            int colIndex = 3*(col/3)+i%3;
            if(rowIndex == row && colIndex == col){
                continue;
            } else if(board[rowIndex][colIndex] != '.' &&
                    board[rowIndex][colIndex] == c){
                return false;
            }
        }
        return true;
    }
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0;i<board.length;i++){
            for(int j = 0;j<board[0].length;j++){
                if(board[i][j] != '.'){
                    if(!isValidSudoku(board, i, j, board[i][j])) return false;
                }
            }
        }
        return true;
    }
}