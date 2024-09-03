import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        Map<String, List<String>> memo = new HashMap<>();

        for(int i = 0; i < strs.length; i++) {
            String str = strs[i];
            char[] strArr = str.toCharArray();
            Arrays.sort(strArr);
            String sortStr = Arrays.toString(strArr);

            if(memo.containsKey(sortStr)) {
                List<String> arr = memo.get(sortStr);
                arr.add(str);
            } else {
                List<String> temp = new ArrayList<>();
                temp.add(str);
                memo.put(sortStr, temp);
            }

        }        

        for(List<String> temp: memo.values()) {
            ans.add(temp);
        }


        return ans;
        

    }
}
