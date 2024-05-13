class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        // n * n
        char[][]board =new char[n][n];
        for(char[] row: board)
            Arrays.fill(row, '.'); // row 배열안에 모든값 '.' 으로 
        int curr_cnt = 0 ; 
        backtrack(0,n,curr_cnt, board, ans); 
        return ans;      
    }
    public static void backtrack(int row, int n, int curr_cnt, char[][] board, List<List<String>> ans) {
        if(curr_cnt == n) {
            List<String> a = new ArrayList<>();
            for(char[] r: board)
                a.add(new String(r));
            ans.add(a);
            curr_cnt = 0;
            return ;
        }

        for(int col = 0; col < n; col++) {
            if(isValid(row,col, board, n)) {
                board[row][col] = 'Q';
                backtrack(row+1, n,curr_cnt + 1, board, ans);
                board[row][col] = '.';
            }
        }
    }
    public static boolean isValid(int row, int col, char[][] board,int n) {
        // 열 확인 ⬆️
        for(int i =0 ;i < row ; i++) {
            if(board[i][col] == 'Q') return false;
        }
        // 왼쪽 대각선 확인 ↖️
        for(int i= row -1, j=col-1 ; i >= 0 && j >= 0 ; i--,j--) {
            if(board[i][j] == 'Q') return false;
        }
        //오른쪽 대각선 ↗️
        for(int i = row -1, j= col+1; i>=0 && j <n;i--,j++) {
            if(board[i][j] == 'Q') return false;
        }
        return true;
    }
}