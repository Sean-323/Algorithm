import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int node;
        int cost;
        
        public Node(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b, c));
        }
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int[] distances = dijkstra(start, n, graph);

        System.out.println(distances[end]);
        
        br.close();
    }
    
    public static int[] dijkstra(int start, int n, ArrayList<ArrayList<Node>> graph) {

        int[] distances = new int[n + 1];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[start] = 0;
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));  // (노드, 비용)
        
        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int currentNode = current.node;
            int currentCost = current.cost;

            if (distances[currentNode] < currentCost) {
                continue;
            }

            for (Node neighbor : graph.get(currentNode)) {
                int newCost = currentCost + neighbor.cost;
                if (newCost < distances[neighbor.node]) {
                    distances[neighbor.node] = newCost;
                    pq.offer(new Node(neighbor.node, newCost));
                }
            }
        }
        
        return distances;
    }
}