import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        for (int t = 0; t < n; t++) {
            int m = Integer.parseInt(br.readLine().trim());
            Map<String, Integer> schools = new HashMap<>();

            for (int i = 0; i < m; i++) {
                String[] input = br.readLine().trim().split(" ");
                String name = input[0];
                int num = Integer.parseInt(input[1]);
                schools.put(name, num);
            }

            String maxSchool = "";
            int maxValue = -1;
            for (Map.Entry<String, Integer> entry : schools.entrySet()) {
                if (entry.getValue() > maxValue) {
                    maxValue = entry.getValue();
                    maxSchool = entry.getKey();
                }
            }

            System.out.println(maxSchool);
        }
    }
}