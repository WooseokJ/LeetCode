import java.util.*;

class Solution {
    public static int[] dr = {0,0,1,-1};
    public static int[] dc = {1,-1,0,0};

    public int numIslands(char[][] grid) {
        int ans =0;
        int rowLen = grid.length;
        int colLen = grid[0].length;
        boolean[][] visited = new boolean[rowLen][colLen];
        for(int i =0; i < rowLen; i++) {
            for(int j =0; j < colLen;j++) {
                if((grid[i][j] == '1' )  && (!visited[i][j])) {
                    bfs(i,j,visited, grid);
                    ans++;
                    
                }
                
            }
        }
        return ans;
        

    }
    public static void print(Object o) {
        System.out.println(o);
    }
   
    public static void bfs(int r, int c, boolean[][] visited, char[][] grid) {
        int rowLen = grid.length;
        int colLen = grid[0].length;
        Deque<Point> q = new ArrayDeque<>();
        q.offer(new Point(r,c));
        visited[r][c] = true;
        while(!q.isEmpty()) {
            Point cur = q.poll();
            int curRow = cur.r;
            int curCol = cur.c;
            for(int i =0; i < 4; i++) {
                int nr = dr[i] + curRow;
                int nc = dc[i] + curCol;
                if( (0 <= nr && nr < rowLen) && (0 <= nc && nc < colLen) ) {
                    if(!visited[nr][nc] && grid[nr][nc] == '1') {
                        q.offer(new Point(nr, nc));
                        visited[nr][nc] = true;
                    }
                }

            }
        }


    }


    public static class Point {
        int r, c;
        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }

    }
}