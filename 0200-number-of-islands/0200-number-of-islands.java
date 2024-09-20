class Solution {
    public int numIslands(char[][] grid) {
        int ans = 0;
        int rowLen = grid.length;
        int colLen = grid[0].length;
        boolean[][] visited = new boolean[rowLen][colLen];
        for(int r =0; r < rowLen; r++) {
            for(int c =0; c< colLen; c++) {
                if((grid[r][c] == '1')) {
                    if(!visited[r][c]) {
                        bfs(r,c,visited, grid);
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
    public static void bfs(int r, int c, boolean[][] visited, char[][] grid) {
        int[] dr = {1,-1,0,0};
        int[] dc = {0,0,1,-1};

        visited[r][c] = true;
        
        for(int i =0; i < 4; i++) {
            int nextRow = r + dr[i];
            int nextCol = c + dc[i];
            if(isValid(nextRow, nextCol, grid)) {
                if(!visited[nextRow][nextCol]) {
                    if(grid[nextRow][nextCol] == '1') {
                        bfs(nextRow, nextCol, visited, grid);
                    }
                    
                }
            }
        }
    }
    public static boolean isValid(int r, int c, char[][] grid) {
        int rowLen = grid.length;
        int colLen = grid[0].length;
        return ((0 <= r && r < rowLen ) && (0 <= c && c < colLen));
    }
}