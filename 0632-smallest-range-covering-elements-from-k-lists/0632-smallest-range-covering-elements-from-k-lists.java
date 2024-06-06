import java.util.*;
class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int[] ans = {0,0};
        Queue<Info> pq = new PriorityQueue<>();

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i =0; i < nums.size(); i++) {
            // 각 배열의 첫번쨰 원소 꺼내.
            List<Integer> numList = nums.get(i);
            int firstVal = numList.get(0);
            // 큐에 오름차순으로 정렬됨.
            pq.offer(new Info(firstVal, i, 0));
            min = Math.min(min, firstVal);
            max = Math.max(max, firstVal);            
        }
        // 최소 , 최대값들 ans에 넣기.
        ans[0] = min;
        ans[1] = max;
        int curMinLen = ans[1] - ans[0];


        // queue 순환.
        while(!pq.isEmpty()) {
            // 최소값 뺴줘.
            Info cur = pq.poll();
            
            int newLen = max - cur.first;
            System.out.println(cur.first + " " + newLen + " " + curMinLen);
            if(newLen < curMinLen) {
                curMinLen = newLen;
                System.out.println(curMinLen + " == ");
                min = cur.first;
                ans[0] = cur.first;
                ans[1] = max;
            }
            // col+1 < 현재 배열의 길이 (즉, col이 끝에 도달하는지 아닌지 판단.)
            if(cur.col + 1 < nums.get(cur.row).size()) {
                // 위에서 기존 최소값 뺏으니 새로운 최소값 만들어서 넣어줌.
                int newFirst = nums.get(cur.row).get(cur.col + 1);
                pq.offer(new Info(newFirst, cur.row, cur.col + 1));
                max = Math.max(max, newFirst); // 새로꺼낸값과 기존 최대값 비교.
            
            } else { // 만약 해당행의 범위가 끝나면 종료
                break;
            }

        }
        
        return ans;

    }


    public static class Info implements Comparable<Info>{
        int first, row, col;
        public Info(int first, int row, int col) {
            this.first = first;
            this.row = row;
            this.col = col;
        }
        @Override
        public int compareTo(Info o) {
            return this.first - o.first; // 최소힙. [0,4,5]
        } 

    }


}

