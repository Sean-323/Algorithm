import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<Character, Integer> dict = new HashMap<>();

        for (int i = 0; i < 26; i++) {
            dict.put((char)('a' + i), i + 1);
        }

        for (int i = 0; i < 26; i++) {
            dict.put((char)('A' + i), i + 27);
        }

        String str = br.readLine().trim();
        int sum = 0;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (dict.containsKey(c)) {
                sum += dict.get(c);
            }
        }

        if (isPrime(sum)) {
            System.out.println("It is a prime word.");
        } else {
            System.out.println("It is not a prime word.");
        }
        
        br.close();
    }

    public static boolean isPrime(int n) {
        if (n == 1) {
            return true;
        }
        if (n <= 1) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        
        int sqrtN = (int) Math.sqrt(n) + 1;
        for (int i = 2; i <= sqrtN; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}