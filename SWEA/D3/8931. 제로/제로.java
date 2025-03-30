import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
 
class Solution{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine().trim());
        for (int tc = 1; tc <= T; tc++) {
            Stack<Integer> stack = new Stack<>();
            int K = Integer.parseInt(br.readLine().trim());
            for (int i = 0; i < K; i++) {
                int num = Integer.parseInt(br.readLine().trim()); 
                if (num == 0) {
                    if (!stack.isEmpty()) stack.pop();
                } else stack.push(num);
            }
            int total = 0;
            int size = stack.size();
            for (int i = 0; i < size; i++) {
                total += stack.pop();
            }
            bw.write("#" + tc + " " + total + "\n");
        }
        bw.flush();
        bw.close();
    }
}