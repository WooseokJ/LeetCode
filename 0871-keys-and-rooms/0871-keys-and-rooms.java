import java.util.*;
import java.util.stream.*;
class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        bfs(0, visited, rooms);


        // 
        for(boolean select: visited) {
            if(!select) {
                return false;
            }
        }        
        return true;


    }
    public static void bfs(int start_node, boolean[] visited, List<List<Integer>> rooms) {
        Deque<Integer> q = new ArrayDeque<>();
        visited[start_node] = true;
        q.offer(start_node);
        while(!q.isEmpty()) {
            int cur_node = q.poll();
            List<Integer> keySet = rooms.get(cur_node);
            for(Integer next_node: keySet) {
                if(!visited[next_node]) {
                    q.offer(next_node);
                    visited[next_node] = true;
                }
            }

        }
    }
}