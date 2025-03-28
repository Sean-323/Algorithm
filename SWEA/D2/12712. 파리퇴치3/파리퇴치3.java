import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution
{
	static int[] dx = {-1, 1, 0, 0}; // 상하좌우
    static int[] dy = {0, 0, -1, 1}; // 상하좌우
    static int[] dxDiag = {-1, -1, 1, 1}; // 좌상 우상 우하 좌하
    static int[] dyDiag = {-1, 1, 1, -1}; // 좌상 우상 우하 좌하

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine().trim());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            StringBuilder sb = new StringBuilder();
            sb.append("#").append(tc).append(" ");

            // 입력
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[][] boards = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine().trim());
                for (int j = 0; j < N; j++) {
                    boards[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 로직
            int total = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    // 십자(+) 모양 스프레이로 퇴치한 파리 수 계산
                    int plusKill = boards[i][j];

                    for (int k = 0; k < 4; k++) {
                        for (int dist = 1; dist < M; dist++) {
                            int nx = i + dx[k] * dist;
                            int ny = j + dy[k] * dist;

                            // 범위 체크
                            if (nx >= 0 & nx < N && ny >= 0 && ny < N) plusKill += boards[nx][ny];
                        }
                    }

                    int crossKill = boards[i][j];

                    for (int k = 0; k < 4; k++) {
                        for (int dist = 1; dist < M; dist++) {
                            int nx = i + dxDiag[k] * dist;
                            int ny = j + dyDiag[k] * dist;

                            // 범위 체크
                            if (nx >= 0 & nx < N && ny >= 0 && ny < N) crossKill += boards[nx][ny];
                        }
                    }

                    total = Math.max(total, Math.max(plusKill, crossKill));
                }
            }
            sb.append(total).append("\n");

            // 출력
            bw.write(sb.toString());
        }

        bw.flush();
        bw.close();
        br.close();
    }
}