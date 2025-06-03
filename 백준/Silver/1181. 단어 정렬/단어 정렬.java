import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine().trim());

        Set<String> wordSet = new HashSet<>();
        for (int i = 0; i < N; i++) wordSet.add(br.readLine().trim());

        String[] words = wordSet.toArray(new String[0]);

        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (s1.length() != s2.length()) return s1.length() - s2.length();
                return s1.compareTo(s2);
            }
        });

        for (String word : words) sb.append(word).append("\n");

        System.out.println(sb);
    }
}