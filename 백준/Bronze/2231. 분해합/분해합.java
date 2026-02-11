import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int digitSum(int x) {
        int sum = 0;
        while (x > 0) {
            sum += x % 10;
            x /= 10;
        }
        return sum;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int digits = String.valueOf(N).length();
        int start = Math.max(0, N - 9 * digits);

        int ans = 0;
        for (int x = start; x < N; x++) {
            int dsum = x + digitSum(x);
            if (dsum == N) {
                ans = x;    
                break;
            }
        }

        System.out.println(ans);
    }
}