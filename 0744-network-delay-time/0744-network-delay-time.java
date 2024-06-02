class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // 방향 그래프 만들기.
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for(int[] timeInfo: times) {
            int node = timeInfo[0];
            int connectNode = timeInfo[1];
            int time= timeInfo[2];

            graph.putIfAbsent(node,new ArrayList<>());
            graph.get(node).add(new int[]{node, connectNode, time});
        }

        int[] visited= new int[n+1];
        int INF = Integer.MAX_VALUE;
        Arrays.fill(visited, INF);

        // 큐에 {노드, 거리 } 배열 들어감.
        Queue<int[]> pq = new PriorityQueue<>( (e1,e2) -> e1[1] - e2[1] );
        pq.offer(new int[]{k,0});
        visited[k] = 0;

        //  k부터 모든노드 최단거리 구하기 (다익스트라 수행)
        int ans = 0;
        int visitedCnt = 1;
        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            int u = cur[0];
            int time = cur[1];
            if(visited[u] < time) continue;
            ans = time;

            // 연결된 간선 탐색
            if(!graph.containsKey(u)) continue;
            for(int[] edge: graph.get(u)) {
                int v = edge[1];
                int w = edge[2];
                if(time + w >= visited[v]) continue;
                if(visited[v] == INF) {visitedCnt++;} 
                visited[v] = time + w;
                pq.offer(new int[] {v, time + w});
            }
        }

        if(visitedCnt == n) return ans;
        else return -1;
    }
}