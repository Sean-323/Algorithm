import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] sumArr = new int[N + 1];

        st = new StringTokenizer(br.readLine().trim());

        for (int i = 1; i <= N; i++) sumArr[i] = sumArr[i - 1] + Integer.parseInt(st.nextToken());

        // 로직
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine().trim());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            sb.append(sumArr[B] - sumArr[A - 1]).append("\n");
        }

        // 출력
        System.out.print(sb);
    }

}
