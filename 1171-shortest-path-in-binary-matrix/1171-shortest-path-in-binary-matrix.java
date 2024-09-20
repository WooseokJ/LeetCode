class Solution {
    public static int[] dr = {0,0,1,-1,1,1,-1,-1};
    public static int[] dc = {1,-1,0,0,1,-1,1,-1};
    public static int ans = 0;
    public int shortestPathBinaryMatrix(int[][] grid) {
        int rowLen = grid.length;
        int colLen = grid[0].length;
        boolean[][] visited = new boolean[rowLen][colLen];

        if(grid[rowLen-1][colLen-1] == 1 || grid[0][0] == 1) {
            return -1;
        }
        bfs(0,0,visited, grid);   
        return ans;
    }
    public static void bfs(int r, int c, boolean[][] visited, int[][] grid) {
        
        int rowLen = grid.length;
        int colLen = grid[0].length;
        visited[r][c] = true;
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{r,c, 1});

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int curRow = cur[0];
            int curCol = cur[1];
            int curStep = cur[2];
            
            // 종단에 도착하면? 끝내!
            if( (curRow == rowLen-1 ) && (curCol == colLen-1))  {
                ans = curStep;
                return ;
            }
            for(int i = 0; i < 8; i++) {
                int nextRow = curRow + dr[i];
                int nextCol = curCol + dc[i];
           
                if(isValid(nextRow, nextCol, rowLen, colLen)) {
                    if((grid[nextRow][nextCol] == 0)) {
                        if(!visited[nextRow][nextCol]) {
                            q.offer(new int[]{nextRow, nextCol, curStep+1});
                            visited[nextRow][nextCol] = true;
                        }
                    } 
                }
            }

            ans = -1;
        }
    }
    public static boolean isValid(int r, int c , int rowLen, int colLen) {
 
        return ( (0 <= r && r < rowLen) && (0<=c && c < colLen) );
    }
}
// 0 0 0 0 1
// 1 0 0 0 0 
// 0 1 0 1 0
// 0 0 0 1 1 
// 0 0 0 1 0 