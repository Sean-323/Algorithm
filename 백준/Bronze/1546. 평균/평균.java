import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] scores = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) scores[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(scores);
        int maxNum = scores[N - 1];
        
        double sum = 0.0;
        for (int i = 0; i < N; i++) sum += (double) scores[i] / maxNum * 100.0;
        
        System.out.println(sum / N);
    }

}
