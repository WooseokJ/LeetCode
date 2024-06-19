class Solution {
    public int coinChange(int[] coins, int amount) {
        
        // 예외 반환
        if(amount == 0) {return 0;} 
        boolean[] visited = new boolean[amount+1];// 0 ~ 11으로 노드에대한 방문여부판단.
        return bfs(amount, visited, coins);
    }
    public static int bfs(int amount, boolean[] visited, int[] coins) {
       Deque<Pair> q = new ArrayDeque<>();
        q.offer(new Pair(amount, 1)); // 시작을 amount 와 detph 1로 시작.

        while(!q.isEmpty()) {
            Pair cur = q.poll();  // 현재 amount, detph 갖음.
            for(int i = 0; i < coins.length; i++) { // coins개수 각각에대해 amount 뺴줘 
                int nextAmount = cur.amount - coins[i]; 
                if(nextAmount == 0) { // 0이되면 해당 depth반환.
                    return cur.ans ;
                } 
                if(nextAmount > 0){ // 빼다보면 nextAmount가 음수될수있으므로 
                    if(!visited[nextAmount]) { // 아직 방문하지않은 노드이면 (이미 방문한 노드들을 더 dfs한다해도 nextAmount가 0 되진않았다.)
                        q.offer(new Pair(nextAmount, cur.ans+1)); 
                        // 11(amount) 1(detph) / 8(amount) 1(depth) / 7(amount) / 1(depth)
                        // 10(amount) 2(detph) / 7(amount) 2(depth) / 6(amount) / 2(depth)
                        // .. 저장.
                        visited[nextAmount] = true;
                    }
                }
            }
        }
        // 탐색해봐도 0 이 안나오는거면 불가능하다고 판단하고 -1 반환.
        return -1;
    }

    public static class Pair {
        int amount;
        int ans; // depth
        public Pair(int amount, int ans ) {
            this.amount = amount;
            this.ans = ans;
        }
    }

    
}