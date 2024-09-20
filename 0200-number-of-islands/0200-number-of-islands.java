class Solution {
    
    public int numIslands(char[][] grid) {
        int[] ans = {0};

        int rowLen = grid.length;
        int colLen = grid[0].length;
        boolean[][] visited = new boolean[rowLen][colLen];

        for(int r = 0; r < rowLen; r++) {
            for(int c = 0; c < colLen; c++) {
                if(!visited[r][c]) {
                    if(grid[r][c] == '1') {
                        dfs(r,c,grid,visited);
                        ans[0]++;
                    }
                }
            }
        }
        return ans[0];
    }

    public static void dfs(int r, int c, char[][] grid, boolean[][] visited) {
        visited[r][c] = true;

        int[] dr = {0,0,1,-1, 1,1,-1,-1};
        int[] dc = {1,-1,0,0, 1,-1,1,-1};
        int rowLen = grid.length;
        int colLen = grid[0].length;

        for(int i =0; i < 4; i++) {
            int nextRow = r + dr[i];
            int nextCol = c + dc[i];
            if(isValid(nextRow, nextCol, grid)) {
                if(!visited[nextRow][nextCol]) {
                    if(grid[nextRow][nextCol] == '1') {
                        dfs(nextRow, nextCol, grid, visited);
                    }
                }
            }
        }
    }
    public static boolean isValid(int r, int c, char[][] grid) {
        int rowLen = grid.length;
   int colLen = grid[0].length;
        return ((0 <= r && r < rowLen) && (0 <= c && c < colLen));
    }
}