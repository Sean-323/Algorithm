import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] numbers = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) numbers[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(numbers);

        int good = getGood(N, numbers);
        System.out.println(good);
    }

    private static int getGood(int N, int[] numbers) {
        int good = 0;

        for (int i = 0; i < N; i++) {
            int target = numbers[i];
            int startIdx = 0, endIdx = N - 1;

            while (startIdx < endIdx) {
                if (startIdx == i) { startIdx++; continue; }
                if (endIdx == i) { endIdx--; continue; }

                int sum = numbers[startIdx] + numbers[endIdx];

                if (sum == target) {
                    good++;
                    break;
                } else if (sum < target) startIdx++;
                else endIdx--;
            }
        }
        return good;
    }
}
