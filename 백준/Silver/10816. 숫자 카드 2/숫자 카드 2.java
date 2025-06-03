import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine().trim());
        Map<Integer, Integer> cardCount = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        for (int i = 0; i < N; i++) {
            int card = Integer.parseInt(st.nextToken());
            cardCount.put(card, cardCount.getOrDefault(card, 0) + 1);
        }

        int M = Integer.parseInt(br.readLine().trim());
        st = new StringTokenizer(br.readLine().trim());

        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());
            sb.append(cardCount.getOrDefault(target, 0)).append(" ");
        }

        System.out.println(sb);
    }
}