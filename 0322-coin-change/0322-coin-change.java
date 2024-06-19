class Solution {

    public int coinChange(int[] coins, int amount) {
        int ans = -1;

        int[] memo = new int[amount+1];
        Arrays.fill(memo, -1);

        for(int i = 1; i <= amount; i++) { 
            ans = amount ;
            for(int coin: coins) {
                int remain = i - coin; 
                if(remain < 0) continue;
                ans = Math.min(ans, memo[remain] + 1);
                
            }
            memo[i] = ans;
        }

        if(memo[amount] == amount ) {
            System.out.println("==" + amount);
            ans = -1;
        } else {
            ans = memo[amount] + 1;
        }
        return ans;
    }



}
