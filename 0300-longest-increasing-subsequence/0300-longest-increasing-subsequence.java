import java.util.*;

class Solution {
    static int ans = 0;
    public int lengthOfLIS(int[] nums) {
        // return downup(nums);
        return lis(nums, nums.length);
    }

  // lis() returns the length of the longest
    // increasing subsequence in arr[] of size n
    public static int lis(int arr[], int n) {
        int lis[] = new int[n];
        int i, j, max = 0;

        // Initialize LIS values for all indexes
        for (i = 0; i < n; i++)
            lis[i] = 1;

        // Compute optimized LIS values in
        // bottom up manner
        for (i = 1; i < n; i++)
            for (j = 0; j < i; j++)
                if (arr[i] > arr[j] && lis[i] < lis[j] + 1)
                    lis[i] = lis[j] + 1;

        // Pick maximum of all LIS values
        for (i = 0; i < n; i++)
            if (max < lis[i])
                max = lis[i];

        return max;
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