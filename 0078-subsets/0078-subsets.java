import java.util.*;
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(new ArrayList<>(), 0, nums, ans);
        return ans;
    }
    public static void backtrack(List<Integer> curr, int start, int[] nums, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(curr));
        for(int i = start; i < nums.length; i++) {
            curr.add(nums[i]);
            backtrack(curr, i+1, nums, ans);
            curr.remove(curr.size()-1);
        }


    }
}