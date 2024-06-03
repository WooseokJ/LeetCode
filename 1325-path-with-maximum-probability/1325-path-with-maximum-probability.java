import java.util.*;

class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        
        // 무향 그래프
        Map<Integer, List<Entry>> graph = new HashMap<>();
        for(int i =0; i < edges.length; i++) {
            int[] edge = edges[i];
            int curNode = edge[0];
            int nextNode = edge[1];
            double percent = succProb[i];

            graph.putIfAbsent(curNode, new ArrayList<>());
            graph.putIfAbsent(nextNode, new ArrayList<>());
            graph.get(nextNode).add(new Entry(curNode, percent));
            graph.get(curNode).add(new Entry(nextNode, percent));            
        }
        System.out.println(graph.keySet());

        for(Integer i : graph.keySet()) {
            List<Entry> a = graph.get(i);
            for(Entry e: a) {
                System.out.printf("%d %.2f", e.node, e.weight);
            }
            System.out.println();
        }
        
        


        double[] distance = new double[n+1]; // (0,0,0,0,0)
        Queue<Entry> pq = new PriorityQueue<>();
        pq.offer(new Entry(start, 1.0)); // start, 1.0(학률)
        distance[start] = 1.0;

        while(!pq.isEmpty()) {
            Entry cur = pq.poll();
            if(distance[cur.node] > cur.weight) continue;

            if(graph.containsKey(cur.node)) {
                List<Entry> arr = graph.get(cur.node);

                for(Entry next: arr) {
                    double totalPercent = cur.weight * next.weight;
                    if(totalPercent > distance[next.node]) {
                        distance[next.node] = totalPercent;
                        pq.add(new Entry(next.node, totalPercent));
                    }
                }
            }
           
        }
        return distance[end];
    }

    public static class Entry implements Comparable<Entry> {
        int node; 
        double weight;
        public Entry(int node, double weight) {
            this.node = node;
            this.weight = weight;
        }

        @Override
        public int compareTo(Entry o) {
            return (o.weight == this.weight) ? 0 : ((this.weight > o.weight ) ? -1 : 1);
        }
    }
}