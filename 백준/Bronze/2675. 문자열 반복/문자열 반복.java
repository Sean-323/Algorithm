import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int R = Integer.parseInt(st.nextToken());
            char[] arr = st.nextToken().toCharArray();

            for (int j = 0; j < arr.length; j++) {
                for (int k = 0; k < R; k++) {
                    sb.append(arr[j]);
                }
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}