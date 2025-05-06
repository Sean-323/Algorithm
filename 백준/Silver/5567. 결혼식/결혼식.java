import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<Integer>[] graph;
    static int n;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        System.out.println(bfs(1));
    }
    
    static int bfs(int start) {
        boolean[] visited = new boolean[n + 1];
        visited[start] = true;
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{start, 0});
        
        int count = 0;
        
        while (!queue.isEmpty()) {
            int[] current = queue.pollFirst();
            int person = current[0];
            int depth = current[1];
            
            if (depth >= 2) {
                continue;
            }
            
            for (int friend : graph[person]) {
                if (!visited[friend]) {
                    visited[friend] = true;
                    count++;
                    queue.add(new int[]{friend, depth + 1});
                }
            }
        }
        
        return count;
    }
}