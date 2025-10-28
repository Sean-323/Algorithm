import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 입력
        String A = br.readLine().trim();
        String B = br.readLine().trim();

        int[] countA = new int[26];
        int[] countB = new int[26];
        int result = 0;

        // 로직
        countA = getAlphabetCount(A);
        countB = getAlphabetCount(B);

        for (int i = 0; i < 26; i++) {
            if (countA[i] > countB[i]) result+= countA[i] - countB[i];
            else if (countB[i] > countA[i]) result+= countB[i] - countA[i];
        }

        // 출력
        System.out.println(result);
    }

    public static int[] getAlphabetCount(String str) {
        int[] count = new int[26];
        for (int i = 0; i < str.length(); i++) count[str.charAt(i) - 'a']++;
        return count;
    }
}
