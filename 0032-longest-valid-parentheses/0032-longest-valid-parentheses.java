import java.util.*;
class Solution {
    public int longestValidParentheses(String str) {
        int ans = 0;
        int n = str.length();
        
        Stack<Pair> stack = new Stack<>();
        stack.add(new Pair(-1, ')'));

        for(int idx =0 ; idx <n; idx++) {
            Character keyword = str.charAt(idx);
            if(keyword == '(') {
                stack.add(new Pair(idx, keyword));
            } else { // ')'
                stack.pop();
                if(stack.isEmpty()) {
                    stack.add(new Pair(idx, ')'));
                } else {
                    int len = idx - stack.peek().index;
                    ans = Math.max(ans,len);
                }
            }
        }

        return ans;
    }
    public static class Pair {
        int index;
        Character keyword;
        public Pair(int index, Character keyword) {
            this.index = index;
            this.keyword = keyword;
        }
    }
}