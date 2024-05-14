import java.util.*;

class Solution {
    public boolean isValid(String str) {
        Stack<Character> stack = new Stack<>();
        int n = str.length();
        
        for(int i =0; i < n; i++) {
            char keyword = str.charAt(i);
            if(keyword == '(') {
                stack.add(')');
            } else if (keyword == '{') {
                stack.add('}');
            } else if(keyword == '[') {
                stack.add(']');
            } else { // ] ) } 셋중 하나 
                if( (!stack.isEmpty()) && (stack.peek() == keyword) ){ // 비어있지 않고 스택 top의 원소가 keyword와 같으면
                    stack.pop(); // 빼자.
                } else { // 스택 top이외라면 유효하지않음.
                    return false; 
                }
            }
        }
        return stack.isEmpty();
    }
}