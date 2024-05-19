class Solution {
    public int coinChange(int[] coins, int amount) {
        // 예외 반환
        if(amount == 0) {return 0;} 

        // 
        boolean[] visited = new boolean[amount+1];    // 0 ~ 11으로 노드에대한 방문여부판단.
        
        Deque<Pair> q = new ArrayDeque<>();
        q.offer(new Pair(amount, 1)); // 시작을 amount 와 detph 1로 시작.

        while(!q.isEmpty()) {
            Pair cur = q.poll(); 
            for(int i = 0; i < coins.length; i++) {
                int nextAmount = cur.amount - coins[i];
                if(nextAmount == 0) {
                    return cur.depth ;
                } else if(nextAmount > 0){
                    if(!visited[nextAmount]) {
                        q.offer(new Pair(nextAmount, cur.depth+1));
                        visited[nextAmount] = true;
                    }
                }
            }
        }
        return -1;
    
    

    }

    public static class Pair {
        int amount;
        int depth;
        public Pair(int amount, int depth) {
            this.amount = amount;
            this.depth = depth;
        }
    }

    
}