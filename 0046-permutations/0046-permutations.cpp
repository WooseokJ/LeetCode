

#include <vector>
#include <iostream>

using namespace std;

class Solution {
public:
    vector<vector<int>> permute(vector<int>& nums) {
        vector<vector<int>> ans;
        vector<int> curr;
        backtrack(curr, nums, ans);
        return ans;
    }

private:
    void backtrack(vector<int>& curr, vector<int>& nums, vector<vector<int>>& ans) {
        int n = nums.size();
        // Base case
        if (curr.size() == n) {
            ans.push_back(curr); // Add a copy of current permutation to the answer
            return;
        }
        for (int num : nums) { // Iterate over nums elements
            if (find(curr.begin(), curr.end(), num) == curr.end()) { // If num is not in curr
                curr.push_back(num);
                backtrack(curr, nums, ans);
                curr.pop_back(); // Backtrack
            }
        }
    }
};

