import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] board = new int[N + 1][N + 1];
        int[][] subBoard = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) board[i][j] = Integer.parseInt(st.nextToken());
        }

        // 로직
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) subBoard[i][j] = subBoard[i][j - 1] + subBoard[i - 1][j] - subBoard[i - 1][j - 1] + board[i][j];
        }


        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int result = subBoard[x2][y2] - subBoard[x1 - 1][y2] - subBoard[x2][y1 - 1] + subBoard[x1 - 1][y1 - 1];

            sb.append(result).append("\n");
        }

        // 출력
        System.out.print(sb);
    }

}
