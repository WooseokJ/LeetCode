
#include <iostream>
#include <vector>
#include <string>

using namespace std;


class Solution {
public:
    string getPermutation(int n, int k) {
         vector<int> nums;
        for (int i = 1; i <= n; ++i) {
            nums.push_back(i);
        }
        
        string ans;
        
        while (n > 1) { 
            int page = factorial(n - 1); // (n-1)! permutations per block
            int idx = (k - 1) / page; // find the index in the current list
            k = (k - 1) % page + 1; // adjust k for the next block
            ans.push_back(nums[idx] + '0'); // append the number to the result
            nums.erase(nums.begin() + idx); // remove the used number
            --n;
        }
        ans.push_back(nums[0] + '0'); // append the last remaining number
        return ans;
    }


private:
    int factorial(int n) {
        if (n == 0 || n == 1) return 1;
        int result = 1;
        for (int i = 2; i <= n; ++i) {
            result *= i;
        }
        return result;
    }
};



