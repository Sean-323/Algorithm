import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        
        int m = Integer.parseInt(br.readLine());
        
        ArrayList<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }
        
        int result = bfs(x, y, graph, n);
        System.out.println(result);
    }
    
    static int bfs(int start, int end, ArrayList<Integer>[] graph, int n) {
        int[] visited = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            visited[i] = -1;
        }
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start, 0});
        visited[start] = 0;
        
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int current = curr[0];
            int dist = curr[1];
            
            if (current == end) {
                return dist;
            }
            
            for (int neighbor : graph[current]) {
                if (visited[neighbor] == -1) {
                    visited[neighbor] = dist + 1;
                    queue.offer(new int[]{neighbor, dist + 1});
                }
            }
        }
        
        return -1;
    }
}