import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    static int[] fibo;

    public static int DFS(int N) {
        if (fibo[N] > 0) return fibo[N];
        else if (N == 0) return 0;
        else if (N == 1)
            return 1;
        else return fibo[N] = DFS(N - 1) + DFS(N - 2);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine().trim());

        fibo = new int[N + 1];
        sb.append(DFS(N));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
