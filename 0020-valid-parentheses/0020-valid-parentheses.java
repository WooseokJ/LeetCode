import java.util.*;

class Solution {
    public boolean isValid(String str) {
		    // step1. stack선언.
        Stack<Character> stack = new Stack<>(); 

        // step2. 문자열길이만큼 순회
        for(int i =0; i < str.length(); i++) { 
            char keyword = str.charAt(i);
            // step3. 해당 키워드가 (, {, [ 중 하나 이면 닫는괄호 ), }, ] 맞게 stack에 저장.
            if(keyword == '(') {
                stack.add(')');
            } else if (keyword == '{') {
                stack.add('}');
            } else if(keyword == '[') {
                stack.add(']');
            } else { // ] ) } 셋중 하나 
		            // 스택이 비어있지 x + stack의 맨위 원소가 keyword와 같으면
                if( (!stack.isEmpty()) && (stack.peek() == keyword) ){  // peek()는 top을 반환만.
                    stack.pop(); // 빼자. pop()는 top을 뺴냄.
                } else { // 스택 top이외라면 유효하지않음.
                    return false; 
                }
            }
        }
        return stack.isEmpty();
    }
}