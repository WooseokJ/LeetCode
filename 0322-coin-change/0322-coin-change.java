import java.util.*;
class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;
        boolean[] visited = new boolean[amount+1];
        return bfs(amount, visited, coins);
    }

    public static int bfs(int amount, boolean[] visited, int[] coins) { 
        Deque<Pair> q = new ArrayDeque<>();
        q.offer(new Pair(amount, 1));

        while(!q.isEmpty()) {
            Pair cur = q.poll();
            
            for(int coin: coins) {
                int nextAmount = cur.amount - coin;    

                if(nextAmount == 0) {
                    return cur.ans;
                }
                if(nextAmount > 0 && !visited[nextAmount]) {
                    
                    visited[nextAmount] = true;
                    q.offer(new Pair(nextAmount, cur.ans + 1));
                }
            }
        }
        return -1;


    }
    public static class Pair {
        int ans , amount ;
        public Pair(int amount, int ans){
            this.ans = ans;
            this.amount = amount;
        }
    }
}