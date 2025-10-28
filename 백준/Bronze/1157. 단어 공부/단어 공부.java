import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        String A = br.readLine().trim().toLowerCase();
        int[] countA = new int[26];

        // 로직
        for (int i = 0; i < A.length(); i++) countA[A.charAt(i) - 'a']++;
        int maxCount = -1;
        char maxAlphabet = '?';

        for (int i = 0; i < 26; i++) {
            if (countA[i] > maxCount) {
                maxCount = countA[i];
                maxAlphabet = (char) ('A' + i);
            } else if (countA[i] == maxCount) maxAlphabet = '?';
        }

        // 출력
        System.out.println(maxAlphabet);
    }
}
