class Solution {
    public int[] twoSum(int[] nums, int target) {
        /** for문(1주차) - 완전탐색 */

        // int n = nums.length;
        // for(int i = 0; i < n; i++) 
            // for(int j = i+1; j < n ;j++) 
                // if(target == nums[i] + nums[j]) 
                    // return new int[]{i,j};
        // return null;


        /** two pointer(2주차) */ 
        // int n = nums.length;
        // // arr = { {0,2}, {1,7}, {2,11},{3,15} } 같은 {index:숫자값} 쌍.
        // int[][] arr = new int[n][2];
        // for(int idx =0 ;idx < n;idx++){
        //     arr[idx][0] = idx; // idx
        //     arr[idx][1] = nums[idx]; // 값
        // }

        // // 숫자값 기준으로 오름차순.
        // Arrays.sort(arr, (o1, o2) -> {
        //     return o1[1] - o2[1]; //숫자값 기준 오름차순.
        //     // return o2[1] - o1[1]; // 숫자값 기준 내림차순.
        // });
        
        // int l = 0; 
        // int r = nums.length-1;

        // while (l <= r) { 
        //     int sum = arr[l][1] + arr[r][1];            
        //     if(sum > target) { // 합이 더 크면 -> 더작은값더해야하니 r-1
        //         r-=1; 
        //     } else if(sum < target) { // 합이더 작으면 -> 더 큰값 더해야하니 l+1
        //         l+=1;
        //     } else {  // 발견 
        //         return new int[]{arr[l][0], arr[r][0]}; // l,r의 위치의 원래 idx값.
        //     }
        // }
        // return null;

        /** 5주차 hashTable */
        // 반환해야하는건 [num1의 idx, num2의 idx]
        // <값, idx> 
        Map<Integer, Integer> memo = new HashMap<>();
        
        for(int curIdx = 0; curIdx< nums.length; curIdx++) {
            int findVal = target - nums[curIdx]; // 찾는값 = 목표값 - 현재원소.
            if(memo.containsKey(findVal)) { // 찾는값이 있으면?
                int findValIdx = memo.get(findVal); // 찾는값의 index 꺼내.
                return new int[]{findValIdx, curIdx};
                
            } else {
                memo.put(nums[curIdx], curIdx);
            }
            
        }
        return new int[]{-1,-1};
    }
}