import java.util.*;

class Solution {
    public int numIslands(char[][] grid) {
        int rowLen = grid.length;
        int colLen = grid[0].length;
        int ans = 0;
        boolean[][] visited = new boolean[rowLen][colLen];
        for(int r = 0; r < rowLen; r++) {
            for(int c= 0; c < colLen; c++) {
                if(grid[r][c] == '1'  && !visited[r][c]) {
                    // bfs(r,c,visited, grid);
                    dfs(r,c,visited, grid);
                    ans ++;
                }
            }
        }
        return ans;
    }
    public static void dfs(int r ,int c, boolean[][] visited, char[][] grid) {
        visited[r][c] = true;
        int[] dr = {0,0,1,-1};
        int[] dc = {1,-1,0,0};

        for(int i = 0; i < 4 ;i ++) {
            int nextRow = dr[i] + r;
            int nextCol = dc[i] + c;
            if(isValid(nextRow, nextCol, grid)) {
                if(grid[nextRow][nextCol] == '1' && !visited[nextRow][nextCol]) {
                    dfs(nextRow, nextCol, visited, grid);
                }
            }
        }
    }

    public static void bfs(int r, int c, boolean[][] visited, char[][] grid) {
        visited[r][c] = true;
        Deque<Point> q = new ArrayDeque<>();
        q.offer(new Point(r,c));

        int[] dr = {0,0,1,-1};
        int[] dc = {1,-1,0,0};

        while(!q.isEmpty()) {
            Point cur = q.poll();
            for(int i = 0; i < 4; i++) {
                int nextRow = cur.r + dr[i];
                int nextCol = cur.c + dc[i];
                if(isValid(nextRow, nextCol, grid)) {
                    if((grid[nextRow][nextCol] == '1') && (!visited[nextRow][nextCol])) {
                        visited[nextRow][nextCol] = true;
                        q.offer(new Point(nextRow, nextCol));
                    }
                }

            }
        }
        
    }
    public static boolean isValid(int r, int c, char[][] grid) {
        int rowLen = grid.length;
        int colLen = grid[0].length;
        return ( (0 <= r && r < rowLen)  && (0 <= c && c < colLen));
    }
    public static class Point {
        int r, c;
        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }


}