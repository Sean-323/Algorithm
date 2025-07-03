import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    public static int maxK(long N) {
        return (int)((-1 + Math.sqrt(1 + 8.0 * N)) / 2);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine().trim());

        long[] inputs = new long[num];
        for (int i = 0; i < num; i++) inputs[i] = Long.parseLong(br.readLine().trim());

        StringBuilder sb = new StringBuilder();
        for (long n : inputs) sb.append(maxK(n)).append("\n");

        System.out.print(sb);
    }
}