import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());

        for (int tc = 1; tc <= T; tc++) {
            sb.append("#").append(tc).append(" ");
            StringTokenizer st = new StringTokenizer(br.readLine().trim());

            // 입력
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[][] map = new int[N][M];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine().trim());
                for (int j = 0; j < M; j++) map[i][j] = Integer.parseInt(st.nextToken());
            }

            // 로직
            int maxLen = 0;

            // 가로방향 확인
            for (int i = 0; i < N; i++) {
                int count = 0;
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 1) {
                        count++;
                        maxLen = Math.max(maxLen, count);
                    } else count = 0;
                }
            }

            // 세로방향 확인
            for (int j = 0; j < M; j++) {
                int count = 0;
                for (int i = 0; i < N; i++) {
                    if (map[i][j] == 1) {
                        count++;
                        maxLen = Math.max(maxLen, count);
                    } else count = 0;
                }
            }

            // 출력
            sb.append(maxLen).append("\n");
        }
        System.out.println(sb);
    }

}
