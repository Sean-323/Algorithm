import java.io.*;
import java.util.StringTokenizer;
 
class Solution {
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
            int N = Integer.parseInt(br.readLine().trim());
            int[] trees = new int[N];
            int maxHeight = 0;
 
            // 로직
            st = new StringTokenizer(br.readLine().trim());
 
            // 나무의 초기 높이 입력 및 최대 높이 구하기
            for (int i = 0; i < N; i++) {
                trees[i] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(trees[i], maxHeight);
            }
 
            // 모든 나무가 자라야 할 총 높이 차이와 최대 짝수 날 활용량 계산
            int totalNeededGrowth = 0;  // 모든 나무가 자라야 할 총 높이 차이
            int totalEvenMax = 0;       // 각 나무별로 짝수날에 최대 몇 번 물줄 수 있는지
 
            for (int i = 0; i < N; i++) {
                int diff = maxHeight - trees[i];
                totalNeededGrowth += diff;
                totalEvenMax += diff / 2;  // diff가 홀수인 경우 자동으로 내림
            }
            // 최소 날짜 계산
            int minDays = findMinDays(totalNeededGrowth, totalEvenMax);
 
            // 출력
            sb.append(minDays).append("\n");
            bw.write(sb.toString());
        }
        bw.flush();
        bw.close();
        br.close();
    }
 
    private static int findMinDays(int totalNeededGrowth, int totalEvenMax) {
        // T일 동안 사용할 수 있는 물주기 횟수
        // 홀수일은 (T+1)/2일, 짝수일은 T/2일
 
        // 최소한의 날짜 계산을 위한 이분 탐색
        int left = 0;
        int right = totalNeededGrowth * 2; // 최악의 경우를 가정
 
        while (left < right) {
            int mid = left + (right - left) / 2;
 
            // mid일 동안 사용할 수 있는 물주기 횟수
            int oddDays = (mid + 1) / 2; // 홀수일 (올림)
            int evenDays = mid / 2;      // 짝수일 (내림)
 
            // 짝수일을 최대한 활용
            int usedEven = Math.min(evenDays, totalEvenMax);
            // 짝수일에 2씩 자라므로 총 성장량은 2*usedEven
            // 남은 성장량은 홀수일에 1씩 자라므로
            int neededOdd = totalNeededGrowth - 2 * usedEven;
 
            if (neededOdd <= oddDays) {
                // 홀수일로 남은 성장량을 채울 수 있으면 가능
                right = mid;
            } else {
                // 불가능하면 날짜 증가
                left = mid + 1;
            }
        }
 
        return left;
    }
}