class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(new ArrayList<>(), nums, ans);
        return ans;
    }
    public static void backtrack(List<Integer> curr, int[] nums, List<List<Integer>> ans){ 
        int n = nums.length;
        // base case
        if(curr.size() == n) {
            ans.add(new ArrayList<>(curr)); // curr에는 현재 nums와 동일한 길이의 배열이 만들어져있다.
            return;
        }
        for(int num: nums) { // nums 원소만큼 순회
            if(!curr.contains(num)) { // curr에 포함되지않은숫자면 
                curr.add(num); 
                backtrack(curr, nums, ans);
                curr.remove(curr.size()-1);
            }
        }

        
    }
}