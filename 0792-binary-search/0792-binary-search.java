import java.util.*;
class Solution {
    public int search(int[] n, int target) {
        // 정렬
        List<Integer> temp = new ArrayList<>();
        for(int i =0; i < n.length; i++)
            temp.add(n[i]);
        Collections.sort(temp);
        int[] nums = new int[temp.size()];
        for(int i =0; i< nums.length; i++) {
            nums[i] = temp.get(i);
        } 

        int l = 0;
        int r = nums.length -1;
        while(l <= r) {
            int mid = (l+r) / 2;
            if(nums[mid] > target) {
                r = mid -1;
            } else if(nums[mid] < target) {
                l = mid + 1;
            } else {
                return mid;
            }
        }
        

        return -1;


    }
}