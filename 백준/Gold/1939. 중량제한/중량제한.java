import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<Bridge>> graph;
    
    static class Bridge {
        int destination;
        int weight;
        
        public Bridge(int destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        // 그래프 초기화
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        // 다리 정보 저장 및 최대 무게 찾기
        int maxBridgeWeight = 0;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            
            graph.get(u).add(new Bridge(v, w));
            graph.get(v).add(new Bridge(u, w));
            
            maxBridgeWeight = Math.max(maxBridgeWeight, w);
        }
        
        st = new StringTokenizer(br.readLine());
        int startIsland = Integer.parseInt(st.nextToken());
        int endIsland = Integer.parseInt(st.nextToken());
        
        // 이분 탐색으로 최대 무게 찾기
        int result = findMaxWeight(n, startIsland, endIsland, maxBridgeWeight);
        System.out.println(result);
        
        br.close();
    }
    
    static boolean bfs(int start, int end, int weightLimit, int n) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        
        queue.offer(start);
        visited[start] = true;
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            
            if (current == end) {
                return true;
            }
            
            for (Bridge bridge : graph.get(current)) {
                if (!visited[bridge.destination] && bridge.weight >= weightLimit) {
                    visited[bridge.destination] = true;
                    queue.offer(bridge.destination);
                }
            }
        }
        
        return false;
    }
    
    static int findMaxWeight(int n, int start, int end, int maxBridgeWeight) {
        int low = 1;
        int high = maxBridgeWeight;
        
        while (low <= high) {
            int mid = (low + high) / 2;
            if (bfs(start, end, mid, n)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        return high;
    }
}