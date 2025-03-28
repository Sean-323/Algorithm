import java.util.Scanner;
import java.io.FileInputStream;
 
class Solution {
    static int[] dr = { 0, 1, 0, -1};
    static int[] dc = { 1, 0, -1, 0};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            int[][] arr = new int[N][N];
            int r = 0, c = 0;
            int k = 0;
            arr[0][0] = 1;
            int cnt = 1;
            while(cnt != N * N) {
                int nr = r + dr[k];
                int nc = c + dc[k];
                if(0 > nr || nr >= N || 0 > nc || nc >= N || arr[nr][nc] != 0) {
                    k = (k + 1) % 4;
                    continue;
                }
                r = nr;
                c = nc;
                cnt = cnt + 1;
                arr[r][c] = cnt;
            }
            System.out.println("#" + tc);
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}