import java.util.*;

class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Map<Integer, Boolean> visited = new HashMap<>();
        for(int i = 0; i < rooms.size(); i++) {
            visited.put(i,false);
        }
        bfs(0, visited, rooms);

        for(Map.Entry<Integer, Boolean> entry : visited.entrySet()) {
            Boolean select = entry.getValue();
            if(!select) return false;
        }
        return true;


    }
    public static void bfs(int start_node, Map<Integer, Boolean> visited, List<List<Integer>> rooms) {

        Deque<Integer> q = new ArrayDeque<>();
        visited.put(start_node, true);
        q.offer(start_node);
        while(!q.isEmpty()) {
            int cur_node = q.poll();
            List<Integer> keySet = rooms.get(cur_node);
            for(Integer next_node: keySet) {
                if(!visited.get(next_node)) {
                    q.offer(next_node);
                    visited.put(next_node,true);
                }
            }

        }
    }
}