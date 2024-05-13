class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(new ArrayList<>(),1,n, k, ans);
        return ans;
    }
    private static void backtrack(List<Integer> curr, int start, int n, int k, List<List<Integer>> ans){
        if(curr.size() == k) {
            ans.add(new ArrayList<>(curr));
            return ;
        }
        for(int i = start; i <= n; i++) { // start ~ n 숫자 순회
            curr.add(i); // curr에 start 추가
            backtrack(curr,i+1, n, k, ans); 
            curr.remove(curr.size() - 1);
        }
    }
}