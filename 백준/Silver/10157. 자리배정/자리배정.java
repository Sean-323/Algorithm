import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());

        if (K > C * R) {
            System.out.println(0);
            return;
        }

        int[] dx = {0, 1, 0, -1};
        int[] dy = {-1, 0, 1, 0};

        int[][] seating = new int[R][C];
        int x = 0, y = R - 1;
        int direction = 0;

        for (int num = 1; num <= K; num++) {
            seating[y][x] = num;

            if (num == K) {
                System.out.println((x + 1) + " " + (R - y));
                break;
            }

            int nx = x + dx[direction];
            int ny = y + dy[direction];

            if (nx >= 0 && nx < C && ny >= 0 && ny < R && seating[ny][nx] == 0) {
                x = nx;
                y = ny;
            } else {
                direction = (direction + 1) % 4;
                x = x + dx[direction];
                y = y + dy[direction];
            }
        }
    }
}