class Solution {
    public int search(int[] nums, int target) {
        // step1. 오름차순 정렬
        int[] arr = Arrays.copyOf(nums, nums.length);
        Arrays.sort(arr); // 오름차순

        // step2. left,right 투포인터
        int l = 0;
        int r = arr.length - 1;

        // step3. target, mid 비교
        return backtrack(arr, target, l, r);
    }
    public static int backtrack(int[] arr, int target, int l , int r){
        if(l > r) { // >=로 하면안되는건 원소 1개일떄 무조건 -1이 됨. 
            return -1;
        }
        int mid = (l+r) / 2;
        if(arr[mid] < target) {
            return backtrack(arr, target, mid+1, r);
        } else if(arr[mid] > target) {
            return backtrack(arr, target, l,mid-1);
        } else {
            return mid;
        }
        
    }
}