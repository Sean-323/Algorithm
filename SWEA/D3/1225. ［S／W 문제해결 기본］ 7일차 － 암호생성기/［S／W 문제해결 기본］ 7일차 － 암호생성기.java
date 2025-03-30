import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
class Solution{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int t = 1; t <= 10; t++) { 
            int T = Integer.parseInt(br.readLine().trim()); 
            StringTokenizer st = new StringTokenizer(br.readLine());
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < 8; i++) {
                queue.add(Integer.parseInt(st.nextToken())); 
            }
            int decrement = 1;
            while (true) {
                int num = queue.poll() - decrement; 
                if (num <= 0) {
                    queue.add(0);
                    break;
                }
                queue.add(num);
                decrement = (decrement % 5) + 1; 
            }
            bw.write("#" + t);
            for (int n : queue) {
                bw.write(" " + n);
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}