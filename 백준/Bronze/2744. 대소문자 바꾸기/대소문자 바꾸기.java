import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        String A = sc.nextLine().trim();
        char[] arr = A.toCharArray();

        for (char c : arr) {
            if (c >= 'A' && c <= 'Z') sb.append((char) (c - 'A' + 'a'));
            else sb.append((char) (c - 'a' + 'A'));
        }

        System.out.println(sb);
    }
}
