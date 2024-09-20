import java.util.*;
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(new ArrayList<>(), 1, n, k, ans);
        return ans;    
    }
    public static void backtrack(List<Integer> curr, int start, int n , int k, List<List<Integer>> ans) {
        if(curr.size() == k){
            ans.add(new ArrayList<>(curr));
            return;
        }
        for(int i = start; i <= n; i++) {
            curr.add(i);
            backtrack(curr, i+1, n,k,ans);
            curr.remove(curr.size()-1);
        }
    }
}