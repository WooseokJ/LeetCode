import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        // <key, key에대한 애너그램모음>
        Map<String, List<String>> memo = new HashMap<>();

        
        for(int i =0; i < strs.length ; i++) {
            String curStr = strs[i];
            // 하나뽑고 -> 정렬시키고 -> 정렬시킨거기준으로 new String(sortedStr) 만들고
            // 애니그램 같은건 정렬시키면 동일한 sortedStr 나옴.
            char[] curArr = curStr.toCharArray();
            Arrays.sort(curArr);
            String sortedStr = Arrays.toString(curArr);

            // sortedStr기준으로 memo에 있는지없는지.(
            if(memo.containsKey(sortedStr)) { //이미 sortedStr가 있으면 새로 애너그램모음집에 추가.
                List<String> arr = memo.get(sortedStr);
                arr.add(strs[i]);
            } else { // sortedStr가 memo에 없으면 <sortedStr: 애너그램모음집(curStr)> 저장
                List<String> temp = new ArrayList<String>();
                temp.add(curStr); 
                memo.put(sortedStr, temp); // sortedStr : curStr
            }
        }
        // memo.values()에는 < strtedStr : 같은애너그램모음> 으로 들어있다. 
        for(List<String> temp : memo.values()) {
            ans.add(temp);
        }
        
        return ans;
    }
}