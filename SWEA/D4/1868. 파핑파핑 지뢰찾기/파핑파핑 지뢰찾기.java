import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    static int N;
    static char[][] map;
    static byte[][] mines;
    static boolean[][] visited;
    static final int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static final int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
    static int[] qx, qy;
    static int front, rear;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine().trim());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine().trim());
            map = new char[N][];
            mines = new byte[N][N];
            visited = new boolean[N][N];
            qx = new int[N * N];
            qy = new int[N * N];

            for (int i = 0; i < N; i++) {
                map[i] = br.readLine().trim().toCharArray();
            }

            calcMines();
            int click = countClicks();
            sb.append('#').append(tc).append(' ').append(click).append('\n');
        }
        System.out.print(sb);
    }

    private static void calcMines() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == '*') continue;
                for (int d = 0; d < 8; d++) {
                    int nx = i + dx[d], ny = j + dy[d];
                    if (nx >= 0 && nx < N && ny >= 0 && ny < N && map[nx][ny] == '*') {
                        mines[i][j]++;
                    }
                }
            }
        }
    }

    private static int countClicks() {
        int clicks = 0;
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && map[i][j] != '*' && mines[i][j] == 0) {
                    bfs(i, j);
                    clicks++;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && map[i][j] != '*') clicks++;
            }
        }
        
        return clicks;
    }

    private static void bfs(int startX, int startY) {
        front = rear = 0;
        qx[rear] = startX;
        qy[rear++] = startY;
        visited[startX][startY] = true;

        while (front < rear) {
            int x = qx[front], y = qy[front++];

            for (int d = 0; d < 8; d++) {
                int nx = x + dx[d], ny = y + dy[d];
                
                if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny] && map[nx][ny] != '*') {
                    visited[nx][ny] = true;
                    
                    if (mines[nx][ny] == 0) {
                        qx[rear] = nx;
                        qy[rear++] = ny;
                    }
                }
            }
        }
    }
}