class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();

        char[][] grid = new char[n][n];
        int rowLen = grid.length;
        int colLen = grid[0].length;

        for(int r = 0; r < rowLen; r++) {
            for(int c =0 ; c < colLen; c++) {
                grid[r][c] = '.';
            }
        }

        int curCnt = 0;
        backtrack(0,curCnt, n, grid, ans);
        
        return ans;

    }
    public static void backtrack(int r, int curCnt, int n, char[][] grid, List<List<String>> ans) {
        int rowLen = grid.length;
        int colLen = grid[0].length;

        if(r == n) {
            List<String> temp = new ArrayList<>();
            for(char[] row: grid) {
                temp.add(new String(row));
            }

            curCnt = 0;
            ans.add(temp);
            return ;
        }
        for(int c = 0; c < colLen; c++) {
            if(isValid(r, c, grid)) {
                grid[r][c] = 'Q';
                backtrack(r+1, curCnt+1, n, grid, ans);
                grid[r][c] = '.';
            }
        }
    }
    public static boolean isValid(int r, int c, char[][] grid) {
        int rowLen = grid.length;
        int colLen = grid[0].length;
        // 위쪽 
        for(int curRow = 0; curRow < r; curRow++) {
            if(grid[curRow][c] == 'Q') return false;
        }
        // 왼쪽위대각선
        for(int curRow = (r -1), curCol = (c - 1) ; 0 <= curRow && 0 <= curCol ; curRow--, curCol--) {
            if(grid[curRow][curCol] == 'Q') return false;
        }
        // 오른쪽위대각선
        for(int curRow = r - 1,  curCol = c + 1; 0 <= curRow && curCol < colLen; curRow--, curCol++) {
            if(grid[curRow][curCol] == 'Q') return false;
        }
        return true;
    }
}