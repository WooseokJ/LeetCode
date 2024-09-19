import java.util.*;
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = {0,0};
        int n = nums.length;
        for(int i =0; i < n; i++) {
            for(int j = i+1; j < n; j++) {
                int sum = nums[i] + nums[j];
                if(sum == target) {
                    ans[0] = i;
                    ans[1] = j;
                }
            }
        }
        return ans;
    }
}