class Solution {
    public int uniquePaths(int m, int n) {
        return topdown(m,n);
        // return downup(m,n);
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
}

// down 2, right 6

// dp(0) + dp(1) = dp(2);