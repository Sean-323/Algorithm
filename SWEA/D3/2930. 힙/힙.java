import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
 
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
 
        int T = Integer.parseInt(br.readLine().trim());
 
        for (int tc = 1; tc <= T; tc++) {
            // 입력
            StringBuilder sb = new StringBuilder();
 
            sb.append("#").append(tc).append(" ");
 
            int N = Integer.parseInt(br.readLine().trim()); // 명령의 개수
 
            PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
 
            // 로직
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine().trim());
 
                int operator = Integer.parseInt(st.nextToken());
 
                if (operator == 1) queue.add(Integer.parseInt(st.nextToken()));
                else if (operator == 2) {
                    if (!queue.isEmpty()) sb.append(queue.poll()).append(" ");
                    else sb.append("-1 ");
                }
            }
            sb.append("\n");
            // 출력
            bw.write(String.valueOf(sb));
        }
        bw.flush();
        bw.close();
        br.close();
    }
}