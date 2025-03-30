import java.io.*;
import java.util.StringTokenizer;
 
class Solution {
      public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine().trim());
 
        for (int tc = 1; tc <= T; tc++) {
            StringBuilder sb = new StringBuilder();
            sb.append("#").append(tc).append(" ");
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
 
            // N개의 비트를 모두 1로 만든 마스크
            int mask = (1 << N) - 1;
            // M의 하위 N비트가 모두 1인지 확인
            String result = ((M & mask) == mask) ? "ON" : "OFF";
            sb.append(result).append("\n");
 
            bw.write(sb.toString());
        }
        bw.flush();
        bw.close();
        br.close();
    }
}