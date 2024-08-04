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
            Pair data = q.poll();
            for(int i = 0; i < coins.length;i++){
                int next = data.amount - coins[i];
                if(next == 0) return data.depth;
                if(next > 0)
                    if(!visited[next]) {
                        q.offer(new Pair(next, data.depth+1));
                        visited[next] = true;
                    }
            }
        }
        return -1;
    }
    public static class Pair{
        int amount, depth;
        public Pair(int amount, int depth) {
            this.amount = amount;
            this.depth = depth;
        }
    }
}