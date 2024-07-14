import java.util.*;

class Solution {
    public List<List<String>> partition(String str) {
        List<List<String>> ans = new ArrayList<>();
        
        backtrack(new ArrayList<>(), 0, str, ans);
        return ans;

    }
    public static void backtrack(List<String> curr, int start, String str, List<List<String>> ans) {
        if(start == str.length()) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        for(int i = start; i < str.length() ;i ++) {
            String subStr = str.substring(start, i+1);    
            if(isValid(subStr)) {
                curr.add(subStr);
                backtrack(curr, i+1, str, ans);
                curr.remove(curr.size()-1);
            }

        }
    }
    public static boolean isValid(String subStr) {
        String sb = new StringBuilder(subStr).reverse().toString();
        return subStr.equals(sb);
    }
}