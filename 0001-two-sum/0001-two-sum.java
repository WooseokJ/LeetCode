class Solution {
    public int[] twoSum(int[] nums, int target) {
        // 2중 for문 
        int n = nums.length;
        for(int i =0; i < n; i++) {
            for(int j = i+1; j < n ; j++) {
                if(target == nums[i] + nums[j])
                    return new int[]{i,j};
            }
        }
        
        return null;
    }
}