import java.util.*;
class Solution {
    public int longestValidParentheses(String s) {
        int ans =0;
        int n = s.length();

        Deque<Pair> stack = new ArrayDeque<>();
        stack.push(new Pair(-1, ')'));

        for(int i = 0; i < n; i++) {
            Character keyword = s.charAt(i);
            if(keyword == '(') {
                stack.push(new Pair(i, keyword));
            } else { // ')'
                stack.pop();
                if(stack.isEmpty()) {
                    stack.push(new Pair(i, ')'));
                } else {
                    Pair top = stack.peek();
                    int len = i - top.idx;
                    ans = Math.max(ans, len);
                }
            }
        }
// 0 1 
// ) ( 
        return ans;
        
    }
    public static class Pair {
        int idx;
        Character keyword;
        public Pair(int idx, Character keyword) {
            this.idx = idx;
            this.keyword = keyword;
        }
    }
    
}