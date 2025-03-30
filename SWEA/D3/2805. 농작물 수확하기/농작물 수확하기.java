import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
 
class Solution{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine().trim());
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine().trim());
            int[][] crops = new int[N][N];
            for (int i = 0; i < N; i++) {
                String line = br.readLine().trim();
                for (int j = 0; j < N; j++) crops[i][j] = line.charAt(j) - '0';
            }
            int total = 0;
            int center = N / 2;
            for (int i = 0; i < N; i++) {
                int start = Math.abs(center - i);
                int end = N - start;
                for (int j = start; j < end; j++) total += crops[i][j];
            }
            bw.write("#" + tc + " " + total + "\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }
}