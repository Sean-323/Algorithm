import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution{
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine().trim());
            int[] numbers = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            for (int i = 0; i < N; i++) {
                numbers[i] = Integer.parseInt(st.nextToken().trim());
            }
            int mx_cnt = 0;
            for (int j = 0; j < N; j++) {
                int height = numbers[j];
                int cnt = 0;
                for (int i = j + 1; i < N; i++) {
                    if (numbers[j] > numbers[i]) {
                        cnt++;
                    }
                }
                if (mx_cnt < cnt) {
                    mx_cnt = cnt;
                }
            }
            System.out.println("#" + tc + " " + mx_cnt);
        }
    }
}