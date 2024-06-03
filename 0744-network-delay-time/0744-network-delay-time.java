class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for(int[] timeInfo: times) {
            int node = timeInfo[0];
            int nextNode = timeInfo[1];
            int weight = timeInfo[2];
            graph.putIfAbsent(node, new ArrayList<>());
            graph.get(node).add(new int[] {nextNode, weight});
        }

        int[] visited = new int[n+1];
        int INF = Integer.MAX_VALUE;
        Arrays.fill(visited, INF);

        Queue<int[]> pq = new PriorityQueue<>((e1, e2) -> e1[1] - e2[1]);
        pq.offer(new int[]{k,0});
        visited[k] = 0;

        int ans =0;
        int visitedCnt =1;
        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            int curNode = cur[0];
            int curWeight = cur[1];
            if(visited[curNode] < curWeight ) continue;
            ans = curWeight;

            // 연결된 간선 탐색
            if(!graph.containsKey(curNode)) continue;
            for(int[] edge: graph.get(curNode)) {
                int nextNode = edge[0];
                int nextWeight = edge[1];
                if(visited[nextNode] <= curWeight + nextWeight) continue;
                if(visited[nextNode] == INF) visitedCnt++;
                visited[nextNode] = curWeight + nextWeight;
                pq.offer(new int[]{nextNode, curWeight + nextWeight});
            }
        }
        if(visitedCnt == n) return ans;
        else return -1;
    }
}