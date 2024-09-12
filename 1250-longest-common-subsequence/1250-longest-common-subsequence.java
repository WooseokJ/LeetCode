import java.util.*;

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n1 = text1.length();
        int n2 = text2.length();
        int[][] memo = new int[n1+1][n2+1];
        for(int r= 1; r <= n1; r++) {
            for(int c =1; c<=n2; c++) {
                Character word = text1.charAt(r-1);
                Character word2 = text2.charAt(c-1);
                if(word == word2) {
                    memo[r][c] = memo[r-1][c-1] + 1;
                } else {
                    memo[r][c] = Math.max(memo[r-1][c] , memo[r][c-1]);
                }
            }
        }

                
        return memo[n1][n2];

    }
}