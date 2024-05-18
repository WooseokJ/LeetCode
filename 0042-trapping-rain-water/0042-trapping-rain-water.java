class Solution {
    public int trap(int[] height) {
        int ans = 0;
        int n = height.length;
        Pair l = new Pair(0, height[0]);
        Pair r = new Pair(n-1, height[n-1]);

        while(l.pos < r.pos) { // 
            if(l.max <= r.max) { // l이 기준이됨.
                l.pos++;
                int cur_h = height[l.pos];
                if(cur_h < l.max) { // l기준보다 내려가있으면
                    ans += l.max - cur_h;
                } else { // l기준보다 올라가있어
                    l.max = cur_h; // 높이를 바꿔
                }
            } else { // r 이 기준이됨.
                r.pos--;
                int cur_h = height[r.pos];
                if(cur_h < r.max) { // r기준보다 내려가있으면
                    ans += r.max - cur_h;
                } else { // r기준보다 높으면
                    r.max = cur_h;
                }
            }
        }
        return ans;
        
    }

    public static class Pair {
        int pos;
        int max;
        public Pair(int pos, int max) {
            this.pos = pos;
            this.max = max;
        }
    }

}