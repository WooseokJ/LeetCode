import java.util.*;

class Solution {
    public boolean isValid(String str) {
		    // step1. stack선언.
        Deque<Character> stack = new ArrayDeque<>(); 

        // step2. 문자열길이만큼 순회
        for(int i =0; i < str.length(); i++) { 
            char keyword = str.charAt(i);
            // step3. 해당 키워드가 (, {, [ 중 하나 이면 닫는괄호 ), }, ] 맞게 stack에 저장.
            if(keyword == '(') {
                stack.offerLast(')');
            } else if (keyword == '{') {
                stack.offerLast('}');
            } else if(keyword == '[') {
                stack.offerLast(']');
            } else { // ] ) } 셋중 하나 
		        if(!stack.isEmpty() && stack.peekLast() == keyword) {
                    stack.pollLast();
                } else {
                    return false;
                }

            }
        }

        return stack.isEmpty();
    }
}

