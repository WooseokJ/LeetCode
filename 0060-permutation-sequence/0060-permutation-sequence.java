import java.util.*;

class Solution {
    public String getPermutation(int n, int k) {
        List<List<String>> ans = new ArrayList<>();
        String[] nums = new String[n+1];
        for(int i =1; i <= n;i++) {
            nums[i] = Integer.toString(i);
        }

        boolean[] visited = new boolean[n+1];
        backtrack(new ArrayList<>(), n, k, visited, ans);
        
        StringBuilder sb = new StringBuilder();
        List<String> target = ans.get(k-1);
        for(String str: target) {
            sb.append(str);
        }
        return sb.toString();

    }
    public static void backtrack(List<String> curr, int n , int k , boolean[] visited, List<List<String>> ans) {
        if(curr.size() == n) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        if(ans.size() == k) {
            return ;
        }
        for(int i = 1; i <= n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                curr.add(Integer.toString(i));
                backtrack(curr, n, k, visited, ans);
                curr.remove(curr.size()-1);
                visited[i] = false;
            }
        }

    }
}