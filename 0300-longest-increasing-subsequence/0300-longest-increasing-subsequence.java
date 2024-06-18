import java.util.*;

class Solution {
    static int ans = 0;
    public int lengthOfLIS(int[] nums) {
        // return downup(nums);
        return topdown(nums, nums.length);
    }

    public static int topdown(int arr[], int n) {
        int lis[] = new int[n];
        int i, j, max = 0;
        
        // 다 1 로 바꿔.
        for (i = 0; i < n; i++)
            lis[i] = 1;
        // 순회 
        for (i = 1; i < n; i++)
            for (j = 0; j < i; j++) // 0~j까지 순회
                if (arr[i] > arr[j] && (lis[i] < lis[j] + 1)) // 기준 숫자가 더 크고 
                    lis[i] = lis[j] + 1;

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