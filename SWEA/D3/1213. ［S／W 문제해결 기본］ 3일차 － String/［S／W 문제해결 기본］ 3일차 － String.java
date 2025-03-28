import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
 
class Solution{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int tc = 1; tc <= 10; tc++) {
            int T = Integer.parseInt(br.readLine().trim());
            String target = br.readLine().trim();
            String str = br.readLine().trim();
            int count = str.split(target, -1).length - 1;
            bw.write("#" + tc + " " + count + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}