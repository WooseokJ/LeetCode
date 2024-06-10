import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {    

        int ans = 0, l = 0, r = 0;
        int n = s.length();
        int curLen = 0;
        Set<Character> set = new HashSet<>();
        while(r < n) {
            Character curKeyword = s.charAt(r);
            if(set.contains(curKeyword)) { // abc 있다가 a가 또나와.
                Character t = s.charAt(l);
                set.remove(t);
                l++;
                // curLen++;
            } else { 
                set.add(curKeyword);
                r++;
                curLen = set.size();
            }
            ans = Math.max(ans, curLen);
        }
        
        return ans;

            
        // 괄호문제같이 넣고뺴고 .
        // int ans = 0;
        // int idx = 0;
        // Set<Character> set = new HashSet<>();
        
        // for(int i =0; i < s.length(); i++) {
        //     Character curKeyword = s.charAt(i);
        //     while(set.contains(curKeyword)) {
                
        //         Character newKeyword = s.charAt(idx);
        //         set.remove(newKeyword);
                
        //         idx++;
        //     }
        //     set.add(curKeyword);
        //     ans = Math.max(ans, set.size());
        // }
        // return ans;


        // 풀이 2. 
        // int l = 0, r = 0, ans = 0;
        // int n = s.length();
        // Set<Character> set = new HashSet<>();
        // while(r < n) {
        //     Character curKeyword = s.charAt(r);
        //     if(set.contains(curKeyword)) { // abc 넣다가 새로운 a 만나
        //         Character leftKeyword = s.charAt(l);
        //         set.remove(leftKeyword);
        //         l++;
        //     } else {
        //         Character rightKeyword = s.charAt(r);
        //         set.add(rightKeyword);
        //         r++;
        //         ans = Math.max(ans, set.size());
        //     }
        // }
        // return ans;
    }
}