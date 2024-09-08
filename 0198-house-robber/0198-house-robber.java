import java.util.*;
class Solution {
    public int rob(int[] nums) {
        

        int n = nums.length;
        int[] memo = new int[n+1];
      
        memo[0] = nums[0];
          if(n == 1) return memo[0];
        memo[1] = Math.max(nums[0], nums[1]);


        for(int i = 2 ; i < n ; i++) {
            int newVal = memo[i-2] + nums[i];
            memo[i] = Math.max(memo[i-1] , newVal );
        }
        return memo[n-1];
            
    }


}