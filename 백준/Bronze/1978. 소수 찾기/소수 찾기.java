import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine().trim());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        int result = isPrime(arr);
        System.out.println(result);
    }

    private static int isPrime(int[] arr) {
        int count = 0;
        for (int num : arr) {
            if (num < 2) continue; // 0과 1은 소수가 아님
            boolean isPrime = true;
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) count++;
        }

        return count;
    }

}