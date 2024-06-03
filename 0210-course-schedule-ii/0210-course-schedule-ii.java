import java.util.*;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // 방향그래프 선언
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] indegree = new int[numCourses];

        for(int[] edge: prerequisites) {
            int before = edge[1]; 
            int after = edge[0];
            graph.putIfAbsent(before, new ArrayList<>());
            graph.get(before).add(after);
            indegree[after]++;
        }

        Deque<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[numCourses];
        int[] order= new int[numCourses] ;

        int cnt = 0;
        for(int c = 0; c < numCourses; c++) {
            if(indegree[c] == 0) {
                q.add(c);
                visited[c] = true;
                order[cnt] = c;
                cnt++;
            }
        }

        while(!q.isEmpty()) {
            int cur = q.poll();
            if(graph.containsKey(cur)) {
                for(int next: graph.get(cur)) {
                    indegree[next]--;
                    if(indegree[next] == 0) {
                        q.add(next);
                        visited[next] = true;
                        order[cnt] = next;
                        cnt++;
                    }
                }
            }
        }
        
        return (cnt == numCourses) ? order : new int[]{};

    }
}