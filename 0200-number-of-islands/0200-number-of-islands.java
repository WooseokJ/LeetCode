class Solution {
    static int[] dr = {0,0,1,-1};
    static int[] dc = {1,-1,0,0};

    public int numIslands(char[][] grid) {
        int ans =0;
        int rowLen = grid.length;
        int colLen = grid[0].length;
        boolean[][] visited = new boolean[rowLen][colLen];
        for(int r =0 ; r< rowLen; r++) {
            for(int c = 0; c < colLen; c++) {
                if((grid[r][c] == '1' ) && (!visited[r][c]) ) { // 1이 보이고 , 방문안한거면 dfs시작.
                    dfs(r,c,visited, grid);
                    ans++;
                }
            }
        }
        
        return ans;
    }
    public static void dfs(int r, int c, boolean[][] visited, char[][] grid) {
        visited[r][c] = true;
        for(int i =0; i < 4; i++) {
            int nextRow = r + dr[i];
            int nextCol = c + dc[i];
            if(isValid(nextRow, nextCol, grid)) {
                if( (grid[nextRow][nextCol] == '1') && (!visited[nextRow][nextCol])) {
                    dfs(nextRow, nextCol, visited, grid);
                }
            } 
        }
    }
    public static boolean isValid(int r, int c, char[][] grid) {
        int rowLen = grid.length;
        int colLen = grid[0].length;
        return ( 0 <= r && r < rowLen ) && ( 0 <= c && c < colLen);
    }
}