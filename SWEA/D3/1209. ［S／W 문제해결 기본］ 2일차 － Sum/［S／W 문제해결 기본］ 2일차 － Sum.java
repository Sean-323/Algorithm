import java.util.Scanner;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int tc = 1; tc <= 10; tc++) {
            int T = sc.nextInt();
            int[][] arr = new int[100][100];
            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 100; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            int maxSum = 0;
            for (int i = 0; i < 100; i++) {
                int rowSum = 0;
                int colSum = 0;
                for (int j = 0; j < 100; j++) {
                    rowSum += arr[i][j];
                    colSum += arr[j][i];
                }
                maxSum = Math.max(maxSum, rowSum);
                maxSum = Math.max(maxSum, colSum);
            }
            int leftDiagonal = 0;
            int rightDiagonal = 0;
            for (int i = 0; i < 100; i++) {
                leftDiagonal += arr[i][i];
                rightDiagonal += arr[i][99 - i];
            }
            maxSum = Math.max(maxSum, leftDiagonal);
            maxSum = Math.max(maxSum, rightDiagonal);
            System.out.println("#" + tc + " " + maxSum);
        }
    }
}