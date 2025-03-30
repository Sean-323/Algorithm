import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;
  
class Solution{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int t = 1; t <= 10; t++) {
            LinkedList<String> password = new LinkedList<>();
            br.readLine(); 
            StringTokenizer stk = new StringTokenizer(br.readLine(), " "); 
            while (stk.hasMoreTokens()) password.add(stk.nextToken());
            br.readLine(); 
            stk = new StringTokenizer(br.readLine(), " "); 
            int x, y;
            while (stk.hasMoreTokens()) {
                String command = stk.nextToken();
                switch (command) {
                    case "I":
                        x = Integer.parseInt(stk.nextToken());
                        y = Integer.parseInt(stk.nextToken());
                        for (int i = 0; i < y; i++) password.add(x++, stk.nextToken());
                        break;
                    case "D":
                        x = Integer.parseInt(stk.nextToken());
                        y = Integer.parseInt(stk.nextToken());
                        for (int i = 0; i < y; i++) {
                            if (x < password.size()) password.remove(x);
                        }
                        break;
                    case "A":
                        y = Integer.parseInt(stk.nextToken());
                        for (int i = 0; i < y; i++) password.add(stk.nextToken());
                        break;
                }
            }
            bw.write("#" + t);
            for (int i = 0; i < 10 && i < password.size(); i++) bw.write(" " + password.get(i));
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}