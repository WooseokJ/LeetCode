class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        
        // 방향 그래프 만들기 
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for(int[] timeInfo: times) {
            int node = timeInfo[0]; // u
            int nextNode = timeInfo[1]; // v
            int weight = timeInfo[2]; // w
            // putIfAbsent: key존재시 val반환, 없으면 저장하고 null반환.
            graph.putIfAbsent(node, new ArrayList<>()); 
            graph.get(node).add(new int[] {nextNode, weight}); 
        }
        // 방문여부 리스트 
        int[] visited = new int[n+1];
        int INF = Integer.MAX_VALUE;
        Arrays.fill(visited, INF);
        // 우선순위 큐 ( 큐에 {노드, 거리} 배열 들어감.)
        Queue<NodeInfo> pq = new PriorityQueue<>();
        pq.offer(new NodeInfo(k,0)); // k에서 시작, 가중치 0 
        visited[k] = 0;

        int ans =0;
        int visitedCnt =1;
        // 다익스트라 시작.(K부터 모든노드 최단거리 구하기.)
        while(!pq.isEmpty()) {
            NodeInfo cur = pq.poll();
            int curNode = cur.node;
            int curWeight = cur.weight;
            // 한번 방문한적잇으면 visited[curNode]가 INF가 아니다.
            if(visited[curNode] < curWeight ) continue; 
            ans = curWeight;

            
            if(graph.containsKey(curNode)) { // 해당 key가 있으면 
                // 연결된 간선 탐색
                for(int[] edge: graph.get(curNode)) {
                    int nextNode = edge[0];
                    int nextWeight = edge[1];
                    if(visited[nextNode] <= curWeight + nextWeight) continue;
                    if(visited[nextNode] == INF) visitedCnt++;
                    visited[nextNode] = curWeight + nextWeight;
                    pq.offer(new NodeInfo(nextNode, curWeight + nextWeight));
                }
            }

           
        }
        if(visitedCnt == n) return ans;
        else return -1;
    }

    public static class NodeInfo implements Comparable<NodeInfo> {
        int node;
        int weight;
        public NodeInfo(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
        @Override
        public int compareTo(NodeInfo o) {
            return this.weight - o.weight; // 가중치기준. 최소힙.
        }
    }
}