import java.util.*;
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(new ArrayList<>(), nums, nums.length,  ans);
        return ans;
    }
    public static void backtrack(List<Integer> curr, int[] nums, int k, List<List<Integer>> ans) {
        if(curr.size() == k) {
            ans.add(new ArrayList<>(curr));
            return ;
        }
        for(int i= 0; i < nums.length; i++) {
            if(!curr.contains(nums[i]))  {
                curr.add(nums[i]);
                backtrack(curr, nums,k, ans);
                curr.remove(curr.size()-1);
            }
        }
    }
}