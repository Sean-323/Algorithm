import java.io.*;
import java.util.StringTokenizer;
 
class Solution {
 
    static int N, L; // N : 재료의 수, L : 제한 칼로리
    static int[] cals;
    static int[] scores;
    static int ans;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
 
        int T = Integer.parseInt(br.readLine().trim());
 
        for (int tc = 1; tc <= T; tc++) {
            sb.append("#").append(tc).append(" ");
            // 입력
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
 
            scores = new int[N];
            cals = new int[N];
 
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                scores[i] = Integer.parseInt(st.nextToken());
                cals[i] = Integer.parseInt(st.nextToken());
            }
 
            ans = 0;
 
            // 로직
            make(0, 0, 0);
 
            sb.append(ans).append("\n");
        }
 
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
 
    static void make(int idx, int sumCal, int sumScores) {
        if (sumCal > L) return; // idx - 1번까지의 재료를 이용하여 만들었는데 제한 칼로리를 벗어남
 
        if (idx == N) {
            // 베스트인지는 모르겠지만 일단 햄버거는 만들어졌다.
            if (ans < sumScores) ans = sumScores; // 갱신
            return;
        }
 
        // 뽑는 경우
        make(idx + 1, sumCal + cals[idx], sumScores + scores[idx]);
 
        // 안뽑는 경우
        make(idx + 1, sumCal, sumScores);
    }
}