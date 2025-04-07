import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] triangle = new int[3];

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            for (int i = 0; i < 3; i++)
                triangle[i] = Integer.parseInt(st.nextToken());

            // 종료 조건
            if (triangle[0] == 0 && triangle[1] == 0 && triangle[2] == 0)
                break;

            Arrays.sort(triangle);
            System.out.println(
                Math.pow(triangle[2], 2) == Math.pow(triangle[0], 2) + Math.pow(triangle[1], 2)
                    ? "right" : "wrong");
        }
    }
}