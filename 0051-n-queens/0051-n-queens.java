import java.util.*;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        
        // n * n board
        char[][] board = new char[n][n];
        int rowLen = board.length;
        int colLen = board[0].length;

        // 전부 . 초기화
        for(int r = 0; r < rowLen; r++)
            for(int c = 0; c< colLen; c++)
                board[r][c] = '.';
        
        backtrack(new ArrayList<>(), 0, n,  board, ans);
        return ans;
    }
    public static void backtrack(List<String> curr, int r,int n, char[][] board, List<List<String>> ans) {
        int rowLen = board.length;
        int colLen = board[0].length;

        if(r == n) {
            ans.add(new ArrayList<>(curr));
            return ;
        }
        for(int c = 0; c < colLen; c++) {
            if(isValid(r,c,board)) {
                board[r][c] = 'Q';
                curr.add(new String(board[r]));
                backtrack(curr, r+1, n, board, ans);
                curr.remove(curr.size()-1);
                board[r][c] = '.';
            }
        }
        
    }
    public static boolean isValid(int r, int c, char[][] board) {
        
        int rowLen = board.length;
        int colLen = board[0].length;
        
        // 위 
        for(int cr = 0; cr < r; cr++) {
            if(board[cr][c] == 'Q') return false;
        }   

        // 왼쪽대각선
        for(int cr = r-1, cc = c-1 ; 0 <= cr && 0 <= cc ; cr--, cc-- ) {
            if(board[cr][cc] == 'Q') return false;
        }
            

        // 오른쪽대각선
        for(int cr = r-1, cc = c+1; 0 <= cr && cc < colLen; cc++, cr--)
            if(board[cr][cc] == 'Q') return false;
        return true;

    }
}