import java.io.*;
 
class Solution {
    static boolean isArrive;
    static boolean[][] visited;
    static final int[] dx = {0, 0, -1, 1};
    static final int[] dy = {-1, 1, 0, 0};
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb;
 
        for (int tc = 1; tc <= 10; tc++) {
            sb = new StringBuilder();
            sb.append("#").append(tc).append(" ");
            br.readLine();
 
            int[][] miro = new int[100][100];
 
            for (int i = 0; i < 100; i++) {
                String line = br.readLine().trim();
                for (int j = 0; j < 100; j++) miro[i][j] = line.charAt(j) - '0';
            }
 
            isArrive = false;
            visited = new boolean[100][100];
 
            int x = -1, y = -1, ex = -1, ey = -1;
            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 100; j++) {
                    if (miro[i][j] == 2) {
                        x = i;
                        y = j;
                    }
 
                    if (miro[i][j] == 3) {
                        ex = i;
                        ey = j;
                    }
                }
            }
 
            recursive(100, miro, x, y, ex, ey);
 
            sb.append(isArrive ? 1 : 0).append("\n");
            bw.write(sb.toString());
        }
        bw.flush();
        bw.close();
        br.close();
    }
 
    private static void recursive(int N, int[][] miro, int x, int y, int ex, int ey) {
 
        if (x == ex && y == ey) {
            isArrive = true;
            return;
        }
 
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
 
            if (nx < 0 || nx >= N || ny < 0 || ny >= N ||
                    miro[nx][ny] == 1 || visited[nx][ny]) continue;
 
            visited[nx][ny] = true;
 
            recursive(N, miro, nx, ny, ex, ey);
            visited[nx][ny] = false;
        }
    }
}