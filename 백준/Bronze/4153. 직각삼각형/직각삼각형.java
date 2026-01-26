import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        while (true) {
            int[] x = {sc.nextInt(), sc.nextInt(), sc.nextInt()};
            if (x[0]==0 && x[1]==0 && x[2]==0) break;
            Arrays.sort(x);
            sb.append(x[0]*x[0] + x[1]*x[1] == x[2]*x[2] ? "right\n" : "wrong\n");
        }
        System.out.print(sb);
    }
}
