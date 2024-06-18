import java.util.*;

class Solution {
    static int ans = 0;
    public int lengthOfLIS(int[] nums) {
        return downup(nums);
        // return downup2(nums, nums.length);
    }

    public static int downup2(int[] num, int n) {
        int dp[] = new int[n];
        int ans = 0;
        
        // 모든원소 길이 1 로 초기화.
        for (int i = 0; i < n; i++) 
            dp[i] = 1;
        
        // r 순회.(연속수중 r이 가장 큰수로 생각.)
        for (int r = 1; r < n; r++)
            for (int l = 0; l < r; l++) // 0 ~ r-1까지 순회 
                if (num[r] > num[l]) { // r이 크다는것 확인.
                    dp[r] = Math.max(dp[r], dp[l]+1);
                    // if (dp[r] < dp[l] + 1) // 더 긴 수의나열이 가능하면 업데이트 (dp[r]은 기준점의 길이, dp[l]은 조사하는점의 길이 )
                        // dp[r] = dp[l] + 1;
                } 
                    
     
        
        // 순회하면서 최대값(가장긴 수의나열) 찾기.
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }

    // down up
    public static int downup(int[] nums) {
        // idx, 수의나열 길이
        Map<Integer, Integer> memo = new HashMap<>();
        memo.put(0,1); // 0번쨰 인덱스 의 길이 1 
        int ans = 1;
        for(int r = 1; r < nums.length; r++) {
            memo.put(r,1);
            // 0~r-1까지 조사.
            for(int l = 0; l < r; l++) {
                if(nums[l] < nums[r]) {
                    int val = Math.max(memo.get(r),
                                   memo.get(l) + 1);
                    memo.put(r, val);
                }
        
            }
            ans = Math.max(memo.get(r), ans);
        }
        return ans;
    }
}