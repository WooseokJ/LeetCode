class Solution {
    public boolean exist(char[][] board, String word) {
        int rowLen = board.length;
        int colLen = board[0].length;

        for(int r = 0; r < rowLen; r++) {
            for(int c = 0; c < colLen; c++) {
                if(word.charAt(0) == board[r][c]) {
                    char temp = board[r][c];
                    board[r][c] = ' ';
                    if(backtrack(r,c,board,word,1)) return true;
                    board[r][c] = temp;
                }
            }
        }
        return false;
    }

    public static boolean backtrack(int r, int c, char[][] board, String word, int depth) {
        int[] dr = {1,-1,0,0};
        int[] dc = {0,0,1,-1};

        if(word.length() == depth) return true;
        for(int i=0; i< 4; i++) {
            int nextRow = r + dr[i];
            int nextCol = c + dc[i];
            if(isValid(nextRow, nextCol, board)) {
                if(word.charAt(depth) == (board[nextRow][nextCol]) ) {
                    char temp = board[nextRow][nextCol];
                    board[nextRow][nextCol] = ' ';
                    if(backtrack(nextRow, nextCol, board, word, depth+1)) return true;
                    board[nextRow][nextCol] = temp;

                }
            }
        }
        return false;
    }
    public static boolean isValid(int r, int c, char[][] board) {
        int rowLen = board.length;
        int colLen = board[0].length;
        return ((0 <= r && r < rowLen) && (0 <= c && c < colLen));
    }
}