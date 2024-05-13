class Solution {
    public void solveSudoku(char[][] board) {
        backtrack(board, 0);
    }
    public static boolean backtrack(char[][] board, int n) {
        int row = n / 9;
        int col = n % 9;

        if(n == 81) return true; // 마지막이면 반환
        if(board[row][col] == '.') {
            for(char num = '1'; num <= '9'; num++) {
                if(isValid(row, col, num, board)) {
                    board[row][col] = num;
                    if(backtrack(board, n+1)) return true;
                    board[row][col] = '.';
                }
            }
            return false;
        } else {
            return backtrack(board, n+1);
        }
    }
    public static boolean isValid(int row, int col, int num ,char[][] board) {
        for(int i =0 ;i < 9 ;i++) {
            // 가로 ,세로 같은숫자있는지 판단
            if( (board[i][col] == num) || (board[row][i] == num) ) return false;
            // 3 * 3 내부에서 판단.
            
            // int in_row = 3 *(row / 3 ) + (i / 3);
            // int in_col = 3 * (col /3 ) + (i % 3);
            // if(board[in_row][in_col] == num) return false;d
            int in_row = 3 * (row / 3);
            int in_col = 3 * (col / 3);
            for(int dr = 0 ; dr < 3; dr++) {
                for(int dc = 0; dc < 3; dc++) {
                    if(board[in_row + dr][in_col+dc] == num) return false;
                }
            }
        }
        return true;
        
    }
}