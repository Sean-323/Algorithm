import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int[] numbers = new int[5];
        for (int i = 0; i < 5; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] target = {1, 2, 3, 4, 5};
        
        while (!Arrays.equals(numbers, target)) {
            for (int i = 0; i < numbers.length - 1; i++) {
                if (numbers[i] > numbers[i + 1]) {
                    // Swap elements
                    int temp = numbers[i];
                    numbers[i] = numbers[i + 1];
                    numbers[i + 1] = temp;
                    
                    // Print current state
                    StringBuilder sb = new StringBuilder();
                    for (int j = 0; j < numbers.length; j++) {
                        sb.append(numbers[j]);
                        if (j < numbers.length - 1) {
                            sb.append(" ");
                        }
                    }
                    System.out.println(sb.toString());
                }
            }
        }
    }
}