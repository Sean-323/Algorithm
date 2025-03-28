import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int N, answer;
    static int[][] map;
    static boolean[] desert;
    static int[] dr = {1, 1, -1, -1}; // 우하 좌하 좌상 우상
    static int[] dc = {1, -1, -1, 1}; // 우하 좌하 좌상 우상
    static int startR, startC;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());
        for (int tc = 1; tc <= T; tc++) {
            sb.append("#").append(tc).append(" ");
            // 입력
            N = Integer.parseInt(br.readLine().trim());
            map = new int[N][N];
            answer = -1;

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine().trim());
                for (int j = 0; j < N; j++) map[i][j] = Integer.parseInt(st.nextToken());
            }

            // 로직
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    startR = i;
                    startC = j;
                    desert = new boolean[101];
                    desert[map[i][j]] = true;
                    dfs(i, j, 0, 1, 1); // // r, c, 방향, 먹은 개수, 방향 전환 수
                }
            }

            // 출력
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }

    private static void dfs(int r, int c, int dir, int count, int turnCount) {
        // 다음 위치
        int nr = r + dr[dir];
        int nc = c + dc[dir];

        // 종료 조건: 원래 자리로 돌아오면서 사각형이 됐을 때
        if (nr == startR && nc == startC && count >= 4) {
            answer = Math.max(answer, count);
            return;
        }

        if (nr < 0 || nr >= N || nc < 0 || nc >= N || desert[map[nr][nc]]) return;

        desert[map[nr][nc]] = true;

        dfs(nr, nc, dir, count + 1, turnCount);

        if (dir < 3) dfs(nr, nc, dir + 1, count + 1, turnCount + 1);

        desert[map[nr][nc]] = false;
    }
}