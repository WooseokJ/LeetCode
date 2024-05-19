class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) {return 0;}
        boolean[] visited = new boolean[amount+1];    
        
        Deque<Pair> q = new ArrayDeque<>();
        q.offer(new Pair(amount, 0));

        while(!q.isEmpty()) {
            Pair cur = q.poll();
            for(int i = 0; i < coins.length; i++) {
                int nextAmount = cur.amount - coins[i];
                if(nextAmount == 0) {
                    return cur.cnt+1;
                } else if(nextAmount > 0){
                    if(!visited[nextAmount]) {
                        q.offer(new Pair(nextAmount, cur.cnt+1));
                        visited[nextAmount] = true;
                    }
                }
            }
        }
        return -1;
    
    

    }

    public static class Pair {
        int amount;
        int cnt;
        public Pair(int amount, int cnt) {
            this.amount = amount;
            this.cnt = cnt;
        }
    }

    
}