
import java.util.*;

class Solution {
    public int lengthOfLIS(int[] nums) {
        int ans = 1;
        int n = nums.length;
        int [] memo = new int[n];
        
        for(int i = 0; i < n; i++) {
            memo[i] = 1;
        }
        for(int r = 1 ;r < n; r++) {
            for(int l = 0; l < r; l++) {
                if(nums[r] > nums[l] && (memo[r] < memo[l] + 1)) {
                    memo[r] = memo[l] + 1;
                }
            }
        }
        for(int i: memo) {
            ans = Math.max(ans, i);
        }

        return ans;

    }
}
