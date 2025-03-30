import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
 
class Solution{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine().trim()); 
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            int N = Integer.parseInt(st.nextToken()); 
            int M = Integer.parseInt(st.nextToken()); 
            int[] count = new int[N + M + 1];
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    count[i + j]++; 
                }
            }
            int maxCount = 0;
            for (int i = 2; i <= N + M; i++) {
                maxCount = Math.max(maxCount, count[i]);
            }
            List<Integer> result = new ArrayList<>();
            for (int i = 2; i <= N + M; i++) {
                if (count[i] == maxCount) {
                    result.add(i);
                }
            }
            bw.write("#" + t);
            for (int num : result) {
                bw.write(" " + num);
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}