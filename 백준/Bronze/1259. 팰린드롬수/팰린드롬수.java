import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String s = br.readLine();
            if (s == null) break;    
            if (s.equals("0")) break;

            boolean ok = true;
            int l = 0, r = s.length() - 1;

            while (l < r) {
                if (s.charAt(l) != s.charAt(r)) {
                    ok = false;
                    break;
                }
                l++;
                r--;
            }

            System.out.println(ok ? "yes" : "no");
        }
    }
}