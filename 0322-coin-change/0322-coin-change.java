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
            for(int i =0; i < coins.length; i++) {
                int nextAmount = cur.amount - coins[i];
                if(nextAmount == 0) return cur.ans;
                if(nextAmount > 0 && !visited[nextAmount]) {
                    visited[nextAmount] = true;
                    q.offer(new Pair(nextAmount, cur.ans + 1));
                    
                    
                }
            }
            
        }
        return -1;

    }
    public static class Pair {
        int amount, ans;
        public Pair(int amount, int ans){
            this.amount = amount;
            this.ans = ans;
        }
    }
}