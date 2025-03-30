import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
 
class Solution {
    static int[] prices; // 1일, 1달, 3달, 1년
    static int[] plans; // 달별 이용계획
    static int minCost; // 최소 비용
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb;
        StringTokenizer st;
 
        int T = Integer.parseInt(br.readLine().trim());
 
        for (int tc = 1; tc <= T; tc++) {
            sb = new StringBuilder();
            sb.append("#").append(tc).append(" ");
 
            // 입력
            prices = new int[4];
            plans = new int[12];
 
            st = new StringTokenizer(br.readLine().trim());
            for (int i = 0; i < 4; i++) prices[i] = Integer.parseInt(st.nextToken());
 
            st = new StringTokenizer(br.readLine().trim());
            for (int i = 0; i < 12; i++) plans[i] = Integer.parseInt(st.nextToken());
 
            // 로직
            minCost = prices[3]; // 비용을 1년치인 최대값으로 초기화
            dfs(0, 0); // 0월 부터 시작, 현재 비용 0;
 
            // 출력
            sb.append(minCost).append("\n");
            bw.write(sb.toString());
        }
        bw.flush();
        bw.close();
        br.close();
    }
 
    private static void dfs(int month, int curCost) {
        if (month >= 12) {
            minCost = Math.min(minCost, curCost);
            return;
        }
 
        // 1일 이용권
        dfs(month + 1, curCost + (plans[month] * prices[0]));
 
        // 1달 이용권
        dfs(month + 1, curCost + prices[1]);
 
        // 3달 이용권
        if (month <= 9) dfs(month + 3, curCost + prices[2]);
    }
}