
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine().trim());

        for (int tc = 0; tc < T; tc++) {
            // 입력
            String[] temp = br.readLine().trim().split(" ");
            StringBuilder sb = new StringBuilder();

            for (String s : temp) sb.append(s);

            String target = sb.toString();

            int[] input = new int[26];

            // 로직
            for (int i = 0; i < target.length(); i++) {
                char c = target.charAt(i);
                input[c - 'a']++;
            }
            int maxCount = Integer.MIN_VALUE;
            char maxChar = '?';
            boolean isDuplicate = false;

            for (int i = 0; i < input.length; i++) {
                if (input[i] > maxCount) {
                    maxCount = input[i];
                    maxChar = (char) (i + 'a');
                    isDuplicate = false;
                } else if (input[i] == maxCount && maxCount > 0) isDuplicate = true;
            }

            if (isDuplicate) maxChar = '?';

            //출력
            bw.write(maxChar + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
