import java.io.*;
import java.util.StringTokenizer;
 
class Solution {
    static int N, X, M;
    static int[][] condition;
    static int[] result, temp;
    static int maxHam = -1;
    static BufferedReader br;
    static BufferedWriter bw;
 
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine().trim());
 
        for (int tc = 1; tc <= T; tc++) {
            readInput();
            solve();
            writeOutput(tc);
        }
         
        bw.flush();
        br.close();
        bw.close();
    }
     
    private static void readInput() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
 
        condition = new int[M][3];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine().trim());
            condition[i][0] = Integer.parseInt(st.nextToken()) - 1;
            condition[i][1] = Integer.parseInt(st.nextToken()) - 1;
            condition[i][2] = Integer.parseInt(st.nextToken());
        }
    }
     
    private static void solve() {
        result = new int[N];
        temp = new int[N];
        maxHam = -1;
        dfs(0);
    }
     
    private static void writeOutput(int tc) throws IOException {
        bw.write("#" + tc + " ");
         
        if (maxHam == -1) {
            bw.write("-1\n");
        } else {
            for (int i = 0; i < N; i++) {
                bw.write(result[i] + " ");
            }
            bw.write("\n");
        }
    }
 
    private static void dfs(int idx) {
        if (idx == N) {
            if (isValid()) {
                int sum = 0;
                for (int i = 0; i < N; i++) {
                    sum += temp[i];
                }
                 
                if (sum > maxHam) {
                    maxHam = sum;
                    System.arraycopy(temp, 0, result, 0, N);
                }
            }
            return;
        }
 
        // 가지치기 추가: 특정 조건에 현재 idx가 포함되는지 미리 확인
        boolean canSkip = true;
        for (int[] con : condition) {
            if (con[0] <= idx && idx <= con[1]) {
                canSkip = false;
                break;
            }
        }
         
        // 어떤 조건에도 포함되지 않는 우리는 최대값 X로 설정
        if (canSkip) {
            temp[idx] = X;
            dfs(idx + 1);
            return;
        }
 
        for (int i = 0; i <= X; i++) {
            temp[idx] = i;
            dfs(idx + 1);
        }
    }
 
    private static boolean isValid() {
        for (int c = 0; c < M; c++) {
            int sum = 0;
            int start = condition[c][0];
            int end = condition[c][1];
            int target = condition[c][2];
             
            for (int i = start; i <= end; i++) {
                sum += temp[i];
                if (sum > target) return false; // 이미 초과하면 바로 종료
            }
             
            if (sum != target) return false;
        }
        return true;
    }
}