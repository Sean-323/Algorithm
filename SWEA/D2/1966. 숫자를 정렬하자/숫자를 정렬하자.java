import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
 
class Solution{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine().trim());
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
            Arrays.sort(arr);
            bw.write("#" + tc + " ");
            for (int i = 0; i < N; i++) bw.write(arr[i] + " ");
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}