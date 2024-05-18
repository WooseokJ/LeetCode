class Solution {
    public int trap(int[] height) {
        int ans = 0;
        int n = height.length;
        int l = 0;
        int r = n - 1;
        int lmax = height[0];
        int rmax = height[n-1];

        while(l < r) { // 
            if(lmax <= rmax) { // l이 기준이됨.
                l++;
                int cur_h = height[l];
                if(cur_h < lmax) { // l기준보다 내려가있으면
                    ans += lmax - cur_h;
                } else { // l기준보다 올라가있어
                    lmax = cur_h; // 높이를 바꿔
                }
            } else { // r 이 기준이됨.
                r--;
                int cur_h = height[r];
                if(cur_h < rmax) { // r기준보다 내려가있으면
                    ans += rmax - cur_h;
                } else { // r기준보다 높으면
                    rmax = cur_h;
                }
            }
        }
        return ans;
        
    }
}