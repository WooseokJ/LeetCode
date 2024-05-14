class Solution {
    public int[] twoSum(int[] nums, int target) {
        // for문(1주차) - 완전탐색
        // int n = nums.length;
        // for(int i = 0; i < n; i++) 
            // for(int j = i+1; j < n ;j++) 
                // if(target == nums[i] + nums[j]) 
                    // return new int[]{i,j};
        // return null;


        // two pointer(2주차 )
        
        int n = nums.length;
        // copy = { {0,2}, {1,7}, {2,11},{3,15} } 같은 {index:숫자값} 쌍.
        int[][] copy = new int[n][2];
        for(int idx =0 ;idx < n;idx++){
            copy[idx][0] = idx; // idx
            copy[idx][1] = nums[idx]; // 값
        }
        // 숫자값 기준으로 오름차순.
        Arrays.sort(copy, (o1, o2) -> {
            return o1[1] - o2[1];
        });
        
        int l = 0; 
        int r = nums.length-1;

        while (l < r) { 
            int sum = copy[l][1] + copy[r][1];            
            if(sum > target) {
                r-=1; 
            } else if(sum < target) {
                l+=1;
            } else { 
                return new int[]{copy[l][0], copy[r][0]};
            }
        }
        return null;


    }
}