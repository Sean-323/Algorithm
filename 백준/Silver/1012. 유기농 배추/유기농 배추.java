import java.io.*;
import java.util.*;

public class Main {
    static int n, m, k;
    static int[][] farm;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        farm[x][y] = 0;
        
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int cx = curr[0];
            int cy = curr[1];
            
            for (int d = 0; d < 4; d++) {
                int nx = cx + dx[d];
                int ny = cy + dy[d];
                
                if (0 <= nx && nx < n && 0 <= ny && ny < m && farm[nx][ny] == 1) {
                    farm[nx][ny] = 0;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        int t = Integer.parseInt(br.readLine());
        
        for (int tc = 0; tc < t; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            
            farm = new int[n][m];
            
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int bx = Integer.parseInt(st.nextToken());
                int by = Integer.parseInt(st.nextToken());
                farm[bx][by] = 1;
            }
            
            int ans = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (farm[i][j] == 1) {
                        bfs(i, j);
                        ans++;
                    }
                }
            }
            
            sb.append(ans).append("\n");
        }
        
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}