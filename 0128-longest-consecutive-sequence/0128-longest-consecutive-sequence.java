import java.util.*;
class Solution {
    public int longestConsecutive(int[] nums) {
        int ans = 0;
        int n = nums.length;
        Set<Integer> memo = new HashSet<>();
        for(int i = 0; i < n; i++)
            memo.add(nums[i]);
        
        for(Integer num: memo) {
            if(memo.contains(num-1)) continue;

            int curLen = 1;
            int findNextVal = num + 1;
            while(memo.contains(findNextVal)) {
                curLen++;
                findNextVal++;
            }
            ans = Math.max(curLen, ans);
            
        }
        return ans;
    
    }
}