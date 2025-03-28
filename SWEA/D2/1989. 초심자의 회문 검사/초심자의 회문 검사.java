import java.io.BufferedReader;
import java.io.InputStreamReader;
 
class Solution{
     public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        for (int tc = 1; tc <= T; tc++) {
            StringBuilder sb = new StringBuilder();
            String str1 = br.readLine().trim();
            sb.append(str1);
            if (str1.contentEquals(sb.reverse())) System.out.println("#" + tc + " 1");
            else System.out.println("#" + tc + " 0");
        }
    }
}