

class Solution {
    public List<List<String>> partition(String str) {
        List<List<String>> StringSet = new ArrayList<>();
        backtrack(new ArrayList<>(), 0 ,str, StringSet);
        return StringSet;
    }
    public static void backtrack(List<String> curr, int start, String str, List<List<String>> ans) {
        int strLen = str.length();

        if(start == strLen) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        for(int i = start; i < strLen; i++) {
            String subString = str.substring(start,i+1);
            if(isValid(subString)) {
                curr.add(subString);
                backtrack(curr, i+1, str, ans);
                curr.remove(curr.size()-1);
            }

        }
        
    }
    public static boolean isValid(String str) {
        String reverseString = new StringBuilder(str).reverse().toString();
        return str.equals(reverseString);
    }
}