import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력
        String A = sc.nextLine().trim();
        char[] arr = A.toCharArray();
        String result = "";

        // 로직
        for (char c : arr) {
            if (c >= 'A' && c <= 'Z') result += (char) (c - 'A' + 'a');
                
            else result += (char) (c - 'a' + 'A');
        }

        // 출력
        System.out.println(result);
    }
}
