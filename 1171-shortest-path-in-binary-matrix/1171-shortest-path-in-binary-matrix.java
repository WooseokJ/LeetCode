import java.util.*;
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int ans = 0;

        int rowLen = grid.length;
        int colLen = grid[0].length;
        boolean[][] visited = new boolean[rowLen][colLen];
        visited[0][0] = true;
        if(grid[0][0] == 1 || grid[rowLen-1][colLen-1] == 1) return -1;
        
        Deque<Pair> q = new ArrayDeque<>();
        q.offer(new Pair(0,0,1));
        
        int[] dr = {0,0,1,-1, 1, 1, -1,-1};
        int[] dc = {1,-1,0,0, 1,-1,1,-1};


        while(!q.isEmpty()) {
            Pair cur= q.poll();
            int curRow = cur.row;
            int curCol = cur.col;
            int curDepth = cur.depth;
            if((curRow == rowLen-1) && (curCol == colLen-1)) {
                ans = curDepth;
                return ans;
            }

            for(int i = 0; i < 8; i++) {
                int nextRow = curRow + dr[i];
                int nextCol = curCol + dc[i];
                if(isValid(nextRow, nextCol, rowLen, colLen)) {
                    if(!visited[nextRow][nextCol] && grid[nextRow][nextCol] == 0) {
                        q.offer(new Pair(nextRow, nextCol, curDepth+1));
                        visited[nextRow][nextCol] = true;
                    }
                }
            }
            
        }

        return -1;

    }
    public static boolean isValid(int r, int c, int rowLen, int colLen) {
        return (( 0<= r && r < rowLen) && (0 <= c && c < colLen));
    }

    public static class Pair {
        int row, col, depth;
        public Pair(int row, int col, int depth) {
            this.row = row;
            this.col = col;
            this.depth = depth;
        }
    }
}