class Solution {
    static int ans = 0;
    public int shortestPathBinaryMatrix(int[][] grid) {
        int rowLen = grid.length;
        int colLen = grid[0].length;
        boolean[][] visited = new boolean[rowLen][colLen];
        if(grid[0][0] == 1 || grid[rowLen-1][colLen-1] == 1) return -1;
        bfs(0,0,visited, grid);
        
        return ans;
    }
    public static void bfs(int r, int c, boolean[][] visited, int[][] grid) {
        int rowLen = grid.length;
        int colLen = grid[0].length;
        int[] dr = {1,-1,0,0,1,1,-1,-1};
        int[] dc = {0,0,1,-1,1,-1,1,-1};

        visited[r][c] = true;
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{r,c,1});
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int curRow = cur[0];
            int curCol = cur[1];
            int curStep = cur[2];

            if((curRow == rowLen-1) && (curCol == colLen-1)) {
                ans = curStep;
                return ;
            }

            for(int i = 0 ;i < 8; i++) {
                int nextRow = curRow + dr[i];
                int nextCol = curCol + dc[i];

              
                if(isValid(nextRow, nextCol, rowLen, colLen)) {
                    if(!visited[nextRow][nextCol] && grid[nextRow][nextCol] == 0) {
                        visited[nextRow][nextCol] = true;
                        q.offer(new int[]{nextRow, nextCol , curStep+1});
                    }
                }
            }
            ans = -1;
        }
        
    }

    public static boolean isValid(int r, int c, int rowLen, int colLen) {
        return ((0 <= r && r < rowLen) && (0 <= c && c < colLen));
    }
}