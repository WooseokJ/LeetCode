import java.util.*;
class Solution {
    public int trap(int[] height) {
        int ans = 0;
        Deque<Pair> stack = new ArrayDeque<>();
        int[] trapped = height.clone();
        Pair pop = new Pair(0,0);
        for(int i= 0; i < height.length; i++) {
            int h = height[i];
            while(!stack.isEmpty()) {
                if(h >= stack.peekLast().height) {
                    pop = stack.pollLast();
                } else {
                    break;
                }
            }
            Pair l;
            if(!stack.isEmpty()) {
                l = stack.peekLast();
                for(int j = l.index+1; j<i; j++) {
                    trapped[j] = h;
                }
            } else {
                l = pop;
                for(int j = l.index+1; j <i; j++) {
                    trapped[j] = l.height;
                }
            }
            stack.offerLast(new Pair(i,h));
        }

        for(int i =0; i< height.length;i++) {
            int diff = trapped[i] - height[i];
            ans += diff;
        }
        return ans;
    }
    public static class Pair {
        int index;
        int height;
        public Pair(int index, int height) {
            this.index = index;
            this.height = height;
        }
    }

}