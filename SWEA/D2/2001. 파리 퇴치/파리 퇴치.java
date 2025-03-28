import java.util.Scanner;
 
class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int[][] flies = new int[N][N];
            for (int i = 0; i < flies.length; i++) {
                for (int j = 0; j < flies[i].length; j++) flies[i][j] = sc.nextInt();
            }
            int maxFlies = 0;
            for (int i = 0; i <= N - M; i++) {
                for (int j = 0; j <= N - M; j++) {
                    int sum = 0;
                    for (int x = 0; x < M; x++) {
                        for (int y = 0; y < M; y++) sum += flies[i + x][j + y];
                    }
                    maxFlies = Math.max(maxFlies, sum);
                }
            }
            System.out.println("#" + tc + " " + maxFlies);
        }
    }
}