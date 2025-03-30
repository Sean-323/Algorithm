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
 
            // 입력
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
 
            // 깃발 입력 받기
            char[][] flag = new char[N][];
            for (int i = 0; i < N; i++) flag[i] = br.readLine().trim().toCharArray();
 
            // 로직
 
            // 사전 계산: 각 행을 W, B, R로 칠하는 비용
            int[][] costs = new int[N][3]; // [행][색상(0=W, 1=B, 2=R)]
 
            for (int i = 0; i < N; i++) {
                costs[i][0] = countChanges(flag[i], 'W', M);
                costs[i][1] = countChanges(flag[i], 'B', M);
                costs[i][2] = countChanges(flag[i], 'R', M);
            }
 
            // 최소 색칠 비용 찾기
            int minCost = findMinPaintCost(costs, N);
            sb.append(minCost).append("\n");
 
            // 출력
            bw.write(sb.toString());
        }
        bw.flush();
        bw.close();
        br.close();
    }
 
    private static int findMinPaintCost(int[][] costs, int N) {
        int minCost = Integer.MAX_VALUE;
 
        // 누적 비용 계산 (위에서 아래로)
        int[] whiteCumulative = new int[N];
        whiteCumulative[0] = costs[0][0];
        for (int i = 1; i < N; i++) whiteCumulative[i] = whiteCumulative[i - 1] + costs[i][0];
 
        // 흰색 구간의 마지막 행 i (최소 1행 필요, i < N-2)
        for (int i = 0; i < N - 2; i++) {
            int whiteTotal = whiteCumulative[i];
 
            // 파란색 구간의 마지막 행 j (i+1 ≤ j < N-1)
            int blueTotal = 0;
            for (int j = i + 1; j < N - 1; j++) {
                blueTotal += costs[j][1];
 
                // 빨간색 구간 비용 (j+1 ~ N-1행)
                int redTotal = 0;
                for (int k = j + 1; k < N; k++) redTotal += costs[k][2];
 
                int totalCost = whiteTotal + blueTotal + redTotal;
                minCost = Math.min(minCost, totalCost);
            }
        }
        return minCost;
    }
 
    private static int countChanges(char[] row, char targetColor, int M) {
        int count = 0;
 
        for (int col = 0; col < M; col++) {
            if (row[col] != targetColor) count++;
        }
        return count;
    }
}