import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] arrInput = br.readLine().split(" ");
        Set<Integer> arrSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            arrSet.add(Integer.parseInt(arrInput[i]));
        }

        int m = Integer.parseInt(br.readLine());
        String[] cardsInput = br.readLine().split(" ");

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int card = Integer.parseInt(cardsInput[i]);
            if (arrSet.contains(card)) {
                sb.append("1 ");
            } else {
                sb.append("0 ");
            }
        }

        System.out.println(sb.toString().trim());
    }
}