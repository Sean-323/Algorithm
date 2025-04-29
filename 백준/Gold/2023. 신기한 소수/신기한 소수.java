import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine().trim());

        dfs(2, 1);
        dfs(3, 1);
        dfs(5, 1);
        dfs(7, 1);
        System.out.println(sb);
    }

    static void dfs(int num, int length) {
        if (length == N) {
            sb.append(num).append("\n");
            return;
        }

        for (int i = 0; i <= 9; i++) {
            int next = num * 10 + i;
            if (isPrime(next)) dfs(next, length + 1);
        }
    }

    static boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) if (num % i == 0) return false;
        return true;
    }

}
