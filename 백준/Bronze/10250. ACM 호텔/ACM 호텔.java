import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            int person = Integer.parseInt(st.nextToken());

            int floor = person % H;
            int room = person / H + 1;

            if (floor == 0) {
                floor = H;
                room = person / H;
            }
            sb.append(floor).append(String.format("%02d", room)).append("\n");
        }
        System.out.println(sb);
    }
}
