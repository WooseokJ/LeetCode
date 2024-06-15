import java.util.*;
class Solution {
    // base case 
    // top down VS bottom up

    public int climbStairs(int n) {
        // List쓴거
        return topdown(n);
        // return downup(n);

        // Map쓴거
        // return downup2(n);
        // return topdown2(n);
    }
    public static int topdown2(int n) {
        Map<Integer, Integer> memo = new HashMap<>();
        return dp2(memo, n);
    }
    public static int dp2(Map<Integer, Integer> memo, int n) {
        if(n == 0 || n == 1) return 1;
        if(!memo.containsKey(n)) {
            int sum = dp2(memo, n-1) + dp2(memo, n-2);
            memo.put(n, sum);
        } 
        return memo.get(n);
    }
    public static int downup2(int n) {
        Map<Integer, Integer> memo = new HashMap<>();
        memo.put(0,1);
        memo.put(1,1);
        for(int i = 2; i <= n; i++) {
            int sum = memo.get(i-1) + memo.get(i-2);
            memo.put(i,sum);
        }
        return memo.get(n);
    }
    
    public static int downup(int n ) {
        // bottom up dp(0) + dp(1) = dp(2)
        int[] memo = new int[n+1];
        // base case 미리 
        memo[0] = 1;
        memo[1] = 1;
        for(int i = 2; i <= n ; i++)
            memo[i] = memo[i-1] + memo[i-2];
        return memo[n];
    }


    public static int topdown(int n) {
        // top down   dp(2) = dp(0) + dp(1)
        // 계산된거 저장하는 memo선언.
        int[] memo = new int[n+1];
        Arrays.fill(memo,-1); // -1,-1,-1 .. 
        return dp(memo, n);
    }


    public static int dp(int[] memo, int step) {
        // base case 계산 순서가 dp(0) or dp(1)이면 1 반환.
        if(step== 0 || step == 1) return 1;
        if(memo[step] == -1) memo[step] = dp(memo,step-1) + dp(memo, step-2);
        return memo[step];
    }
}

