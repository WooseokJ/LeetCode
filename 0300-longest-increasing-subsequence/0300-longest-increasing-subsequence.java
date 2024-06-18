import java.util.*;

class Solution {
    public int lengthOfLIS(int[] nums) {
        
        return downup(nums);
    }
    // down up
    public static int downup(int[] nums) {
        if(nums.length == 0) return 0;
        // idx, 길이
        Map<Integer, Integer> memo = new HashMap<>();
        memo.put(0,1); // 0번쨰 인덱스 의 길이 1 
        int ans = 1;
        for(int i = 1; i < nums.length; i++) {
            memo.put(i,1);
            // j = 0~i까지 순회
            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) {
                    int val = Math.max(memo.get(i),
                                   memo.get(j) + 1);
                    memo.put(i, val);
                }
        
            }
            ans = Math.max(memo.get(i), ans);
        }
        return ans;
    }
}