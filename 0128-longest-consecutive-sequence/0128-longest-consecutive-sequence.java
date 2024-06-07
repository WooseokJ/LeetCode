import java.util.*;
class Solution {
    public int longestConsecutive(int[] nums) {
        // int ans = 0;
        // Set<Integer> memo = new HashSet<>();
        // for(int i = 0; i < nums.length; i++) {
        //     memo.add(nums[i]);
        // }

        // for(int num: nums) {
        //     if(memo.contains(num-1)) continue;

        //     int cnt = 1;
        //     int target = num+1;
        //     while(memo.contains(target)) {
        //         target++;
        //         cnt++;
        //     }
        //     ans = Math.max(ans, cnt);
        // }
        // return ans;

        int ans = 0;
        Set<Integer> memo = new HashSet<>();
        for(int i =0; i < nums.length; i++) {
            memo.add(nums[i]);
        }
        for(Integer num: memo) {
            if(memo.contains(num-1)) continue;
            // 연속수중 가장작은수가 num에 들어간다. 
            int curLen = 1; 
            int next = num + 1; // 찾는값.(작은수 + 1) 
            
            while(memo.contains(next)) {
                curLen++; // 길이 늘려 + 1
                next++; // 있으니까 다음에 또 찾는값.
            }
            ans = Math.max(curLen, ans);
        }
        return ans;

       

    }
}
