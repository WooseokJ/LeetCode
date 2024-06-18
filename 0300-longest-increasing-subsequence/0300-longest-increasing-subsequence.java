import java.util.*;

class Solution {
    static int ans = 0;
    public int lengthOfLIS(int[] nums) {
        // return downup(nums);
        return topdown(nums, nums.length);
    }

    public static int topdown(int[] num, int n) {
        int dp[] = new int[n];
        int ans = 0;
        
        // 모든원소 길이 1 로 초기화.
        for (int i = 0; i < n; i++) 
            dp[i] = 1;
        
        // r 순회.(연속수중 r이 가장 큰수로 생각.)
        for (int r = 1; r < n; r++)
            for (int l = 0; l < r; l++) // 0 ~ r-1까지 순회 
                if (num[r] > num[l]) { // r이 가장크다는거 확인. 
                    if (dp[r] < dp[l] + 1) // 더 긴 수의나열이 가능하면 업데이트
                        dp[r] = dp[l] + 1;
                } 
                    
     
        
        // 순회하면서 최대값(가장긴 수의나열) 찾기.
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }

    // down up
    public static int downup(int[] nums) {
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