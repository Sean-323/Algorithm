import java.util.Scanner;

public class Main {
    static int k;
    static int[] arr;
    static int[] result = new int[6];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            k = sc.nextInt();
            if (k == 0) break;

            arr = new int[k];
            for (int i = 0; i < k; i++) arr[i] = sc.nextInt();

            dfs(0, 0);
            System.out.println();
        }
    }

    static void dfs(int start, int depth) {
        if (depth == 6) {
            for (int num : result) System.out.print(num +  " ");
            System.out.println();
            return;
        }

        for (int i = start; i < k; i++) {
            result[depth] = arr[i];
            dfs(i + 1, depth + 1);
        }
    }

}