import java.util.*;

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        // return topdown(cost);
        // return bottomup(cost); // 1초
        // Map 사용

        return topdown2(cost);
        // return downup2(cost); // 4초 
    }
    public static int downup2(int[] cost) {
        int n = cost.length;
        Map<Integer, Integer> memo = new HashMap<>();
        memo.put(1,0);
        memo.put(0,0);
        for(int i =2; i <= n ; i++) {
            int min = Math.min(memo.get(i-1) + cost[i-1], 
                                memo.get(i-2) + cost[i-2]);
            memo.put(i, min);
        }
        return memo.get(n);
    }

        
    public static int topdown2(int[] cost) {
        int n = cost.length;
        Map<Integer, Integer> memo = new HashMap<>();
        return dp2(memo,cost, n);
    }
    public static int dp2(Map<Integer, Integer> memo,int[] cost, int n) {
        if(n == 0 || n == 1) return 0;
        if(!memo.containsKey(n)) {
            memo.put(n,Math.min(dp2(memo, cost, n-1) + cost[n-1], dp2(memo,cost, n-2) + cost[n-2]));
        }
        return memo.get(n);
            
    }

    public static int bottomup(int[] cost) {
        int n = cost.length;
        int[] memo = new int[n+1];    
        memo[0] = 0;
        memo[1] = 0;
        for(int i =2; i <= n ;i++)
            memo[i] = Math.min(memo[i-1]+cost[i-1] , memo[i-2]+cost[i-2]);
        return memo[n];
    }
    public static int topdown(int[] cost) {
        int n = cost.length;
        int[] memo = new int[n+1];
        Arrays.fill(memo,-1);
        return dp(memo,cost, n);
    }
    public static int dp(int[] memo, int[] cost, int n) {
        if(n == 0 || n == 1) return 0;
        if(memo[n] == -1) {
            memo[n] = Math.min(dp(memo, cost, n-1) + cost[n-1] , dp(memo, cost, n-2) + cost[n-2]);
        }  
        return memo[n];
    }
}

// f(n) = f(n-1) + f(n-2)
// f(0) = 0, f(1) = 0