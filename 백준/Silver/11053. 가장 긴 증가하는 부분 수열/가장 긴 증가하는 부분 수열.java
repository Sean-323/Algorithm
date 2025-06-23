import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] numList = new int[n], dp = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numList[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
        }

        for (int i = 0; i < n; i++)
            for (int j = 0; j < i; j++)
                if (numList[i] > numList[j]) dp[i] = Math.max(dp[i], dp[j] + 1);

        int result = 0;
        for (int value : dp) result = Math.max(result, value);
        System.out.println(result);
    }
}