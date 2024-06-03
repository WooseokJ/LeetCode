class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 방향그래프 선언
        Map<Integer, List<Integer>> graph = new HashMap<>();
        // indegree: 처음시작노드들
        int[] indegree = new int[numCourses]; // 0~ numCourses -1
        // b -> a  

        for(int[] edge: prerequisites) {
            int before = edge[1]; 
            int after = edge[0];
            graph.putIfAbsent(before, new ArrayList<>());
            graph.get(before).add(after);
            indegree[after]++;
        }
        
        Deque<Integer> q = new ArrayDeque<>();

        // 위상정렬 수행.(indegree = 0인 정점부터 수행.)
        int cnt = 0;
        for(int c = 0; c < indegree.length; c++) {
            if(indegree[c] == 0) {
                q.offer(c);
                cnt++;
            }
        }

        while(!q.isEmpty()) {
            int cur = q.poll();
            if(graph.containsKey(cur)) {
                for(int next: graph.get(cur)) {
                    indegree[next]--;
                    if(indegree[next] == 0) {
                        q.offer(next);
                        cnt++;
                    }
                }
            }
        }


        return (cnt == numCourses);
        

    }
}