import java.io.*;
import java.util.StringTokenizer;
 
class Solution {
    static boolean isArrive;
    static boolean[] visited;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb;
 
        int T = 10;
        for (int tc = 1; tc <= T; tc++) {
            sb = new StringBuilder();
            sb.append("#").append(tc).append(" ");
 
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            st.nextToken(); // Skip test case number
            int E = Integer.parseInt(st.nextToken());
 
            st = new StringTokenizer(br.readLine().trim());
             
            int V = 100;
            boolean[][] adj = new boolean[V][V]; // Use boolean instead of int for adjacency matrix
             
            // Parse pairs directly into adjacency matrix
            for (int i = 0; i < E; i++) {
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                adj[u][v] = true;
            }
 
            isArrive = false;
            visited = new boolean[V]; // 1D array is sufficient
            dfs(adj, 0, 99);
 
            sb.append(isArrive ? 1 : 0);
            bw.write(sb.toString());
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }
 
    private static void dfs(boolean[][] adj, int current, int end) {
        if (current == end) {
            isArrive = true;
            return;
        }
         
        if (isArrive) return; // Early termination
 
        for (int next = 0; next < adj.length; next++) {
            if (!adj[current][next] || visited[next]) continue;
             
            visited[next] = true;
            dfs(adj, next, end);
             
            if (isArrive) return; // Skip backtracking if path found
             
            visited[next] = false;
        }
    }
}