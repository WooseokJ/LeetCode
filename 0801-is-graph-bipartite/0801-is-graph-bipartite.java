class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        Character[] groups = new Character[n];
        Arrays.fill(groups, '0'); // 0 은 방문x, a , b그룹
        for(int i =0 ; i< n;i++) {
            if(groups[i] == '0') {
                if(!dfs(i, 'a', groups, graph)) {
                    return false;
                }
            }
        }

        return true;

    }
    public static boolean dfs(int cur_node, Character group, Character[] groups, int[][] graph) {
        groups[cur_node] = group;
        for(int next: graph[cur_node]) {
            if(groups[next] == '0') { // 아직 방문 x
                Character newGroup = (group == 'a') ? 'b' : 'a';
                if(!dfs(next, newGroup, groups, graph)) { // 인접노드 다른색으로 칠해.
                    return false;
                } 
            } else if(groups[next] == groups[cur_node]) {
                return false;
            }   
        }
    
        return true;
     
    }


        



 
}