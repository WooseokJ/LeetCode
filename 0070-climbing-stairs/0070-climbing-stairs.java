class Solution {
    public int climbStairs(int n) {
        // top down   dp(3) = dp(2) + dp(1)
        // 계산된거 저장하는 memo선언.
        int[] memo = new int[n+1];
        Arrays.fill(memo,-1); // -1,-1,-1 .. 
        return dp(memo, n);


        // bottom up
        
    }


    public static int dp(int[] memo, int step) {
        // base case 계산 순서가 dp(0) or dp(1)이면 1 반환.
        if(step== 0 || step == 1) return 1;
        else if(memo[step] == -1) memo[step] = dp(memo,step-1) + dp(memo, step-2);
        return memo[step];
    }
}

// base case 
// top down VS bottom up