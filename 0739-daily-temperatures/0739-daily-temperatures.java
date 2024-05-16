import java.util.*;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        Deque<Integer> q = new ArrayDeque<>();

        for(int day = 0; day< n; day++) {
            int cnt = 0;
            int cur_temp = temperatures[day]; // 현재 온도.
    

            while(!q.isEmpty()) {
                if(cur_temp > temperatures[q.peek()]) { // 현재온도가 비교온도보다 높으면 대입
                    int preDay = q.pop();
                    ans[preDay] = day - preDay;
                }else {
                    break;
                }
            }
            q.push(day);
        }
        System.out.println(Arrays.toString(ans));
        return ans;
    }
}
