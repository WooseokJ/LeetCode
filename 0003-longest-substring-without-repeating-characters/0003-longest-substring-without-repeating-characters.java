import java.util.*;


class Solution {
    
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        int curLen = 0;
        int l = 0;
        int r = 0;
        // int l , r = 0;
        // int r = 0;
        Set<Character> memo = new HashSet<>();

        while(r < s.length()) {
            Character rightWord = s.charAt(r);
            if(memo.contains(rightWord)) {
                Character leftWord = s.charAt(l);
                l++;
                memo.remove(leftWord);

            } else {
                memo.add(rightWord);
                
                curLen = Math.max(curLen,memo.size());
                
                r++;
            }
        }
        ans = Math.max(ans, curLen);
        System.out.println(l + " " + r);

        return curLen;        

    }
}