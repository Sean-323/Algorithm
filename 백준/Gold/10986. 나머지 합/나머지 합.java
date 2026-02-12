import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] count = new long[M];   
        long prefix = 0;
        long result = 0;

        count[0] = 1;

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            prefix += Integer.parseInt(st.nextToken());
            int remainder = (int)(prefix % M);
            count[remainder]++;
        }

        for (int i = 0; i < M; i++) {
            long k = count[i];
            result += k * (k - 1) / 2;
        }

        System.out.println(result);
    }
}