import java.util.*;

class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        // 무향 그래프 
        Map<Integer, List<Info>> graph = new HashMap<>();
        for(int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            int curNode = edge[0];
            int nextNode = edge[1];
            double percent = succProb[i];
            graph.putIfAbsent(curNode, new ArrayList<>());
            graph.putIfAbsent(nextNode, new ArrayList<>());
            graph.get(curNode).add(new Info(nextNode, percent));
            graph.get(nextNode).add(new Info(curNode, percent));
        }
        // 시작노드 없으면 바로 반환
        if(!graph.containsKey(start_node)) return 0;
        
        double[] percentArr = new double[n+1];
        Queue<Info> pq = new PriorityQueue<>();
        pq.offer(new Info(start_node, 1.0)); // 스타트, 확률 1 
        percentArr[start_node] = 1.0;
        while(!pq.isEmpty()) {
            Info cur = pq.poll();
            int curNode = cur.node;
            double curWeight = cur.weight;
            if(percentArr[curNode] > curWeight) continue;
            for(Info next: graph.get(curNode)) {
                double newPercent = curWeight * next.weight;
                if(newPercent > percentArr[next.node]) {
                    percentArr[next.node] = newPercent;
                    pq.add(new Info(next.node, newPercent));
                }
            }
        }


        return percentArr[end_node];
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
            double result =  this.weight - o.weight;
            if(result > 0) return -1;
            else if (result < 0) return 1;
            else return 0;
        
        }
    }
}