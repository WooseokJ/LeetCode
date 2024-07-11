import java.util.*;

class Solution {
    public String getPermutation(int n, int k) {
        List<List<Integer>> list = new ArrayList();
        permutation(n, k, list, new ArrayList<>(), new boolean[n+1]);
        String s = "";
        List<Integer> target = list.get(k-1);
        for(int i=0; i<n; i++) {
            s = s + Integer.toString(target.get(i));
        }
        return s;
    }

    private void permutation(int n, int k, List<List<Integer>> list, ArrayList<Integer> now, boolean[] visited) {
        if(now.size() == n) {
            list.add(new ArrayList<>(now));
            return;
        }
        if(list.size() == k) {
            return;
        }
        for(int i=1; i<=n; i++) {
            if(!visited[i]) {
                now.add(i);
                visited[i] = true;
                permutation(n, k, list, now, visited);
                now.remove(now.size() - 1);
                visited[i] = false;
            }
        }
    }
}