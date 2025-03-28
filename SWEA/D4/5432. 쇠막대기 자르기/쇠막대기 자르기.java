import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
 
class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine().trim());
        for (int tc = 1; tc <= T; tc++) {
            String input = br.readLine().trim();
            int result = steelCut(input);
            bw.write("#" + tc + " " + result + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
    public static int steelCut(String input) {
        int stack = 0;
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '(') {
                if (input.charAt(i + 1) == ')' && i + 1 < input.length()) {
                    count += stack;
                    i++;
                } else stack++;
            }else {
                count++;
                stack--;
            }
        }
        return count;
    }
}