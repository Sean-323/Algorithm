import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine().trim());
        double[] scores = new double[N];

        st = new StringTokenizer(br.readLine().trim());
        for (int i = 0; i < N; i++) scores[i] = Double.parseDouble(st.nextToken());
        Arrays.sort(scores);

        double result = 0;

        for (int i = 0; i < N; i++) result += ((scores[i] / scores[N - 1]) * 100);

        System.out.println(result / N);
    }
}
