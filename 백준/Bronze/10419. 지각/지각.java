import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    public static int maxLate(int t) {
        int max = -1;
        for (int i = 0; i <= 100; i++) {
            if (t >= i + i * i) {
                max = i;
            }
        }
        return max;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int t = Integer.parseInt(br.readLine());
            sb.append(maxLate(t)).append("\n");
        }

        System.out.print(sb);
    }
}