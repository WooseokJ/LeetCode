import java.util.*;

class Solution {
    // LCS 를 재귀 이용 방식: O(mn)
    // LCS 를 DP 이용한방식: O(m + n) 
    public int longestCommonSubsequence(String str1, String str2) { 
        int m = str1.length();
        int n = str2.length();
        int[][] memo = new int[m+1][n+1]; 
        for(int r = 1; r <= m; r++) { 
            for(int c = 1; c <= n; c++) {
                if(str1.charAt(r-1 )== str2.charAt(c-1)) { // 글자 같으면
                    memo[r][c] =  memo[r-1][c-1] + 1;
                } else {
                    memo[r][c] =  Math.max(memo[r-1][c], memo[r][c-1]);
                }
            }
        }
        return memo[m][n];
    }
}