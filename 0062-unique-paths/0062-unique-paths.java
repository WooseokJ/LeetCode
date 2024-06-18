import java.util.*;
class Solution {
    public int uniquePaths(int m, int n) {
        return topdown(m,n);
        // return downup(m,n); // 0초

        // Map이용.
        // Point p = new Point(m,n);
        // return p.downup(m,n); // 11초 
        // return p.topdown(m,n); // 13초

    }

    public static int downup(int m , int n) {
        int[][] memo = new int[m][n];
        for(int i = 0; i < m ; i++)
            memo[i][0] = 1;
        for(int i = 0; i < n; i++)
            memo[0][i] = 1;
        for(int i = 1; i < m; i++)
            for(int j = 1; j < n; j++)
                memo[i][j] = memo[i-1][j] + memo[i][j-1];
                // memo[1][1] = memo[0][1] + memo[1][0];
        return memo[m-1][n-1];
    }
    public static int topdown(int m , int n) {
        int[][] memo = new int[m][n];
        for(int i = 0; i < m; i++)
            Arrays.fill(memo[i], -1);
        return dp(memo, m-1,n-1);
    
    }
    public static int dp(int[][] memo, int r, int c) {
        // basecase
        if(r == 0 || c == 0) memo[r][c] = 1;
        if(memo[r][c] == -1) memo[r][c] = dp(memo, r-1,c) + dp(memo,r,c-1);
        return memo[r][c];
    }

    public static class Point {
        int r, c;
        Map<String, Integer> memo;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
            this.memo = new HashMap<>();
        }
        public String getKey(int r, int c) {
            return r+","+c;
        }
        public int downup(int m, int n) {
            for(int i = 0; i < m ; i++)
                memo.put(getKey(i,0), 1);
            for(int i =0; i < n; i++) 
                memo.put(getKey(0,i), 1);
            for(int i =1; i < m; i++) {
                for(int j = 1; j < n; j++) {
                    int down = memo.get(getKey(i-1, j));
                    int right = memo.get(getKey(i, j-1));
                    int sum = down + right;
                    memo.put(getKey(i,j), sum);
                }
            }
            return memo.get(getKey(m-1,n-1));
        }

        public int topdown(int m , int n) {
            return dp(m-1,n-1);
        }
        public int dp(int r, int c) {
            if(r == 0 || c == 0 ) {
                memo.put(getKey(r,c), 1);
                return 1;
            }
            if(!memo.containsKey(getKey(r,c))) {
                int sum = dp(r-1,c) + dp(r,c-1);
                memo.put(getKey(r,c), sum);
            }
            return memo.get(getKey(r,c));
        }

    }

  
}

// down 2, right 6

// dp(0) + dp(1) = dp(2);