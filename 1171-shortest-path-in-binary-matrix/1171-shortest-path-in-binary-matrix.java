import java.util.*;

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int ans = 0;
        int rowLen = grid.length;
        int colLen = grid[0].length;
        boolean[][] visited = new boolean[rowLen][colLen];
        if(grid[0][0] == 1 || grid[rowLen-1][colLen-1] == 1) return -1;
        ans = bfs(0,0,visited, grid);
        return ans;
    }
    public static int bfs(int r, int c, boolean[][] visited, int[][] grid) {
        int[] dr = {0,0,1,-1,1,1,-1,-1};
        int[] dc = {1,-1,0,0,1,-1,1,-1};
        visited[r][c] = true;
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{r,c,1});
        while(!q.isEmpty()){
            int[] cur = q.poll();
            if((cur[0] == grid.length-1) && (cur[1] == grid[0].length-1)) {
                return cur[2];
            }

            for(int i=0; i < 8; i++) {
                int nr = cur[0]+dr[i];
                int nc = cur[1]+dc[i];
                if((0 <= nr && nr < grid.length) && (0 <= nc && nc < grid[0].length)) {
                    if((!visited[nr][nc]) && (grid[nr][nc] == 0)) {
                        visited[nr][nc] = true;
                        q.offer(new int[]{nr,nc,cur[2]+1});
                    }
                }
            }
        }

        
        return -1;
    }
}