class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(new ArrayList<>(),0, nums,ans);   
        return ans;
    }
    public static void backtrack(List<Integer> curr,int start, int[] nums, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(curr));
        int n = nums.length;
        for(int i = start; i < n ; i++){ 
            curr.add(nums[i]);
            backtrack(curr,i+1 ,nums, ans);
            curr.remove(curr.size()-1);
        }
    }

}