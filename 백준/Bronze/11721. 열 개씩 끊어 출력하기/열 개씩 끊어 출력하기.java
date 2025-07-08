import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine().trim();

        for (int i = 0; i < str.length(); i += 10) {
            int end = Math.min(i + 10, str.length());
            System.out.println(str.substring(i, end));
        }
    }
}