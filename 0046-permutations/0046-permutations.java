import java.util.*;
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(new ArrayList<>(), nums, ans);
        return ans;
    }
    public static void backtrack(List<Integer> curr, int[] nums, List<List<Integer>> ans) {
        if(curr.size() == nums.length) {
            ans.add(new ArrayList<>(curr));
            return ;
        }
        for(int i= 0; i < nums.length; i++) {
            if(!curr.contains(nums[i]))  {
                curr.add(nums[i]);
                backtrack(curr, nums, ans);
                curr.remove(curr.size()-1);
            }
        }
    }
}