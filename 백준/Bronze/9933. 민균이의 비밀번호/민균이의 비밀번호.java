import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        ArrayList<String> arr = new ArrayList<>();
        ArrayList<String> reverseArr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String str = br.readLine().trim();
            arr.add(str);
            reverseArr.add(new StringBuilder(str).reverse().toString());
        }

        for (String original : arr) {
            for (String reversed : reverseArr) {
                if (original.equals(reversed)) {
                    int length = original.length();
                    char middleChar = original.charAt(length / 2);
                    System.out.println(length + " " + middleChar);
                    return;
                }
            }
        }
    }
}