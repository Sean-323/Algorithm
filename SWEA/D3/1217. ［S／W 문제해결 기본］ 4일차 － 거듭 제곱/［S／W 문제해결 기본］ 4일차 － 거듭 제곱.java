import java.util.Scanner;
 
class Solution{
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int tc = 1; tc <= 10; tc++) {
            int T = sc.nextInt();
            int N = sc.nextInt();
            int M = sc.nextInt();
            int result = square(N, M);
            System.out.println("#" + T + " " + result);
        }
    }
    public static int square(int N, int M) {
        if (M == 0) return 1;
        if (M == 1) return N;
        int half = square(N, M / 2);
        if (M % 2 == 0) return half * half;
        else return N * half * half;
    }
}