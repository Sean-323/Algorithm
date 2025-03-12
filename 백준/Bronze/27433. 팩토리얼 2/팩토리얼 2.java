import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static long factorial(long N) {
        if (N == 0) return 1;
        else return N * factorial(N - 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        long N = Integer.parseInt(br.readLine().trim());
        sb.append(factorial(N));

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
