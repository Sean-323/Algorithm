import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class Solution {
    static int[][] graph;
    static boolean[] visited;
    static int maxDepth, maxNum;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
 
        for (int tc = 1; tc <= 10; tc++) {
            sb.append("#").append(tc).append(" ");
 
            // 입력
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            int N = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
 
            graph = new int[101][101];
            visited = new boolean[101];
 
            st = new StringTokenizer(br.readLine().trim());
            for (int i = 0; i < N / 2; i++) {
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                graph[from][to] = 1; // 단방향
            }
 
            // 로직
            bfs(start);
            sb.append(maxNum).append("\n");
        }
        System.out.println(sb);
    }
 
    private static void bfs(int start) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{start, 0}); // 사람 번호, 깊이
        visited[start] = true;
 
        maxDepth = 0;
        maxNum = 0;
 
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int now = cur[0];
            int depth = cur[1];
 
            if (depth > maxDepth) {
                maxDepth = depth;
                maxNum = now;
            } else if (depth == maxDepth) maxNum = Math.max(maxNum, now);
 
            for (int i = 1; i <= 100; i++) {
                if (graph[now][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    q.offer(new int[]{i, depth + 1});
                }
            }
        }
    }
}