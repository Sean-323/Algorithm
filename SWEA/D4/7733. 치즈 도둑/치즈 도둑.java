import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int N;
    static int[][] board;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0}; // 상하좌우
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());
        for (int tc = 1; tc <= T; tc++) {
            sb.append("#").append(tc).append(" ");
            // 입력
            N = Integer.parseInt(br.readLine().trim());
            board = new int[N][N];
            int maxHeight = 0;

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine().trim());
                for (int j = 0; j < N; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                    maxHeight = Math.max(maxHeight, board[i][j]);
                }
            }

            // 로직
            int maxArea = 0;

            for (int day = 0; day <= maxHeight ; day++) {
                visited = new boolean[N][N];
                int areaCount = 0;

                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        if (!visited[i][j] && board[i][j] > day) {
                            dfs(i, j, day);
                            areaCount++;
                        }
                    }
                }
                maxArea = Math.max(maxArea, areaCount);
            }
            // 빌더에 담기
            sb.append(maxArea).append("\n");
        }
        System.out.println(sb);
    }

    private static void dfs(int r, int c, int day) {
        visited[r][c] = true;
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr >= 0 && nr < N && nc >= 0 && nc < N
                    && !visited[nr][nc] && board[nr][nc] > day) dfs(nr, nc, day);
        }
    }
}