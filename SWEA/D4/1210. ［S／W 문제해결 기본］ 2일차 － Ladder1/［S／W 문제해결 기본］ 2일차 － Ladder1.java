import java.util.Scanner;
 
class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int t = 0; t < 10; t++) {
            int tc = sc.nextInt();
            int[][] ladder = new int[100][100];
            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 100; j++) {
                    ladder[i][j] = sc.nextInt();
                }
            }
            int start = -1;
            for (int i = 0; i < 100; i++) {
                if (ladder[99][i] == 2) {
                    start = i;
                    break;
                }
            }
            int row = 99;
            int col = start;
            while (row > 0) {
                if (col > 0 && ladder[row][col - 1] == 1) { // 왼쪽 이동
                    while (col > 0 && ladder[row][col - 1] == 1) {
                        col--;
                    }
                } else if (col < 99 && ladder[row][col + 1] == 1) { // 오른쪽 이동
                    while (col < 99 && ladder[row][col + 1] == 1) {
                        col++;
                    }
                }
                row--;
            }
            System.out.println("#" + tc + " " + col);
        }
    }
}