import java.util.*;

class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int[] ans = {0,0};
        Queue<Info> pq = new PriorityQueue<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < nums.size(); i++) {
            // 맨 첫항 꺼내 
            int first = nums.get(i).get(0);
            pq.offer(new Info(first, i, 0)); // 첫항, 행, 0번쨰 열
            min = Math.min(min, first);
            max = Math.max(max, first);
        }

        ans[0] = min;
        ans[1] = max;
        int curLen = max - min;
        while(!pq.isEmpty()) {
            Info cur = pq.poll();
            int curFirstVal = cur.first;
            int curRow = cur.row;
            int curCol = cur.col;

            int newLen = max - curFirstVal;
            // 새로운 길이가 더 짧으면? -> 갱신
            if(newLen < curLen) {
                curLen = newLen;
                min = curFirstVal;  //최소값 갱신.
                ans[0] = min;
                ans[1] = max;
            }   
            // 칼럼길이 
            int colLen = nums.get(curRow).size();
            int nextCol = curCol + 1;
            if(nextCol != colLen) {
                int newFirst = nums.get(curRow).get(nextCol);
                pq.offer(new Info(newFirst, curRow, nextCol));
                max = Math.max(max, newFirst); // 최대값 갱신.
            } else {
                break;
            }


            
        }
        return ans;
        

    }
    public static class Info implements Comparable<Info> {
        int first, row, col;
        public Info(int f, int r, int c) {
            first = f;
            row = r;
            col = c;
        }
        @Override
        public int compareTo(Info o) {
            return this.first - o.first;
        }
    }
}

// [4 10 15 24 26], 
// [0,9,12 20], 
// [5,18,22,30]

// 4 0 5 -> 5 - 0  5   0 제거 
// 5 4 9 -> 9 - 4  5   5제거
// 18 4 9 -> 18 - 4    4제거 
// 18 10 9 -> 18 - 9   9제거 
// 18 10 12 -> 18 - 10 10제거
// 18 15 12 -> 18 - 12 12제거
// 18 15 20 -> 20 - 15 15제거
// 18 24 20 -> 24 - 18 18제거
// 22 24 20 -> 24 - 20 20 제거 

// [1 2 3]
// [1,2,3]
// [1,2,3]