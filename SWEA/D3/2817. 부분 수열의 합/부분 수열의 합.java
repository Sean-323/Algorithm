import java.io.*;
import java.util.StringTokenizer;
 
class Solution {
 
    static int result;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
 
        int T = Integer.parseInt(br.readLine().trim());
        for (int tc = 1; tc <= T; tc++) {
            StringBuilder sb = new StringBuilder();
            sb.append("#").append(tc).append(" ");
 
            // 입력
            // N : 수열의 원소의 개수, K : 부분 집합의 합
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
 
            // 수열 N개 만큼의 원소 arr
            int[] arr = new int[N];
            st = new StringTokenizer(br.readLine().trim());
            for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
 
            // 로직
            // 부분 수열의 합이 K인 경우의 수
            // 해당 원소를 사용할지 유무를 표시하는 배열
            int[] bits = new int[N];
            result = 0;
            subset(arr, bits, N, K, 0);
 
            sb.append(result).append("\n");
 
            // 출력
            bw.write(sb.toString());
        }
        bw.flush();
        bw.close();
        br.close();
    }
     
    // 재귀 함수 형태로 i번째 인덱스의 원소를 사용 유무 O(0), X(1)
    private static void subset(int[] arr, int[] bits, int N, int K, int i) {
        // 종료 조건
        // 모든 요소를 다 선택 (결정) 하였을 때 종료
        if (i == arr.length) {
            int total = 0; // 누적합 변수
 
            // bits에 표기되어 있는 원소 사용 유무를 통해서 합산을 계산
            for (int j = 0; j < bits.length; j++) {
                if (bits[j] == 1) {  // 해당 원소를 사용한다
                    total += arr[j];
                }
            }
            // 내가 찾으려고하는 값인 K와 동일한 누적합인지 확인
            if (total == K) result++;
 
            return;
        }
 
        bits[i] = 0;
        subset(arr, bits, N, K, i + 1);
 
        bits[i] = 1;
        subset(arr, bits,N, K, i + 1);
 
    }
}