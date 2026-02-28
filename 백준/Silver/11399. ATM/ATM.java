import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 입력
        int N = Integer.parseInt(br.readLine());
        int[] people = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) people[i] = Integer.parseInt(st.nextToken());

        // 로직
        Arrays.sort(people);
        int sum = 0;
        int result = 0;

        for (int i = 0; i < N; i++) {
            sum += people[i];
            result += sum;
        }

        // 출력
        System.out.println(result);
    }
}