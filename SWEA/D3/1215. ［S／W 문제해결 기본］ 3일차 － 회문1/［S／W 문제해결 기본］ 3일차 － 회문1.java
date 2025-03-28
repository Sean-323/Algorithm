import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int tc = 1; tc <= 10; tc++) {
            char[][] palindrome = new char[8][8];
            int targetNum = Integer.parseInt(br.readLine().trim());
            for (int i = 0; i < 8; i++) {
                palindrome[i] = br.readLine().toCharArray();
            }
            int count = 0;
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j <= 8 - targetNum; j++) {
                    if (isPalindrome(palindrome[i], j, j + targetNum - 1)) {
                        count++;
                    }
                }
            }
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j <= 8 - targetNum; j++) {
                    if (isVerticalPalindrome(palindrome, i, j, j + targetNum - 1)) {
                        count++;
                    }
                }
            }
            System.out.println("#" + tc + " " + count);
        }
    }
    private static boolean isPalindrome(char[] arr, int start, int end) {
        while (start < end) {
            if (arr[start] != arr[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    private static boolean isVerticalPalindrome(char[][] arr, int col, int start, int end) {
        while (start < end) {
            if (arr[start][col] != arr[end][col]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}