import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String str = br.readLine().trim();
            if (str.equals("0")) break;

            char[] arr = str.toCharArray();

            sb.append(isPalindrome(arr, 0, arr.length -1) ? "yes" : "no").append("\n");
        }

        System.out.println(sb);
    }

    private static boolean isPalindrome(char[] arr, int start, int end) {
        while (start < end) {
            if (arr[start++] != arr[end--]) {
                return false;
            }
        }
        return true;
    }

}