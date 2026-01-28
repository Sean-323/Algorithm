import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);

        boolean[] seen = new boolean[42];

        for (int i = 0; i < 10; i++) {
            int a = sc.nextInt();
            seen[a % 42] = true;
        }

        int result = 0;
        for (boolean b : seen) if (b) result++;

        System.out.println(result);
    }
}