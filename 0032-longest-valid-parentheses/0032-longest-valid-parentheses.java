import java.util.*;
class Solution {
    public int longestValidParentheses(String str) {
        int ans = 0;
        int n = str.length();
        
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);

        for(int i =0 ; i <n; i++) {
            Character keyword = str.charAt(i);
            if(keyword == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if(stack.isEmpty()) {
                    stack.push(i);
                } else {
                    ans = Math.max(ans, i - stack.peek());
                }

            }
        }
        return ans;
    }
}