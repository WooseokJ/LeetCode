import java.util.*;

class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        
        // 무향 그래프 만들기.
        Map<Integer, List<Info>> graph = new HashMap<>();
        for(int i =0; i < edges.length; i++) {
            int[] edge = edges[i];
            int curNode = edge[0];
            int nextNode = edge[1];
            double percent = succProb[i];

            graph.putIfAbsent(curNode, new ArrayList<>());
            graph.putIfAbsent(nextNode, new ArrayList<>());
            graph.get(nextNode).add(new Info(curNode, percent));
            graph.get(curNode).add(new Info(nextNode, percent));            
        }
        // 우선순위큐 {노드, 확률 } 저장.
        double[] percentage = new double[n+1]; // (0,0,0,0,0) // 확률 리스트 
        Queue<Info> pq = new PriorityQueue<>();
        pq.offer(new Info(start, 1.0)); // start, 1.0(학률)
        percentage[start] = 1.0;

        while(!pq.isEmpty()) {
            Info cur = pq.poll();
            if(percentage[cur.node] > cur.weight) continue; // 
            if(graph.containsKey(cur.node)) {
                List<Info> arr = graph.get(cur.node);
                for(Info next: arr) {
                    double newPercent = cur.weight * next.weight;
                    if(newPercent > percentage[next.node]) { // 이전 확률 < 새로운 확률
                        percentage[next.node] = newPercent; // 확률이 더높은 새로운확률로 변경.
                        pq.add(new Info(next.node, newPercent));
                    }
                }
            }
           
        }
        return percentage[end]; // end 지점까지의 최대확률 반환.
    }

    public static class Info implements Comparable<Info> {
        int node; 
        double weight;
        public Info(int node, double weight) {
            this.node = node;
            this.weight = weight;
        }

        @Override
        public int compareTo(Info o) {
            if(this.weight - o.weight > 0 ) return -1;
            else if(this.weight - o.weight < 0) return 1;
            else return 0;
        }
    }
}