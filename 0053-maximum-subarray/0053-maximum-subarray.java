import java.util.*;
class Solution {
    public int maxSubArray(int[] nums) {
        int ans = nums[0];
        int[] memo = new int[nums.length];
        for(int i =0; i < nums.length; i++) {
            memo[i] = nums[i];
        }
        
        for(int i = 1;  i < nums.length; i++) {
            memo[i] = Math.max(memo[i], memo[i] + memo[i-1]);
            ans = Math.max(ans, memo[i]);
        }


        return ans;

    }
}