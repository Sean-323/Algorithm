import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int tc = 1; tc <= 10; tc++) {
            char[][] palindrome = new char[100][100];
            int T = Integer.parseInt(br.readLine().trim());
            for (int i = 0; i < 100; i++) {
                palindrome[i] = br.readLine().toCharArray();
            }
            int maxLength = 0;
            for (int i = 0; i < 100; i++) {
                for (int len = 100; len > maxLength; len--) {
                    for (int start = 0; start + len <= 100; start++) {
                        if(isPalindrome(palindrome[i], start, start + len - 1)) {
                            maxLength = len;
                            break;
                        }
                    }
                }
            }
            for (int i = 0; i < 100; i++) {
                for (int len = 100; len > maxLength; len--) {
                    for (int start = 0; start + len <= 100; start++) {
                        if (isVerticalPalindrome(palindrome, i, start, start + len - 1)) {
                            maxLength = len;
                            break;
                        }
                    }
                }
            }
 
            System.out.println("#" + T + " " + maxLength);
        }
    }
    private static boolean isPalindrome(char[] arr, int start, int end) {
        while (start < end) {
            if (arr[start++] != arr[end--]) {
                return false;
            }
        }
        return true;
    }
    private static boolean isVerticalPalindrome(char[][] arr, int col, int start, int end) {
        while (start < end) {
            if (arr[start++][col] != arr[end--][col]) {
                return false;
            }
        }
        return true;
    }
}