class Solution {
    public int trap(int[] height) {
        int ans = 0;
        int n = height.length;

        Pair l = new Pair(0, height[0]);
        Pair r = new Pair(n-1, height[n-1]);
        System.out.println(l.max + " " + r.max);

        while(l.pos < r.pos) {
            if(l.max < r.max) {
                l.pos++;
                int curHeight = height[l.pos];
                if(curHeight > l.max) {
                    l.max = curHeight;
                    
                    System.out.println(l.pos + " l");
                } else {
                    ans += Math.abs(curHeight-l.max);
                }
            } else {
                r.pos--;
                int curHeight = height[r.pos];
                if(curHeight > r.max) {
                    r.max = curHeight;
                    System.out.println(r.pos + " r");
                } else {
                    ans += Math.abs(curHeight - r.max);
                    
                }
            }
        }
        return ans;
        

    }
    public static class Pair {
        int pos, max;
        public Pair(int pos, int max) {
            this.pos = pos;
            this.max = max;
        }
    }
}