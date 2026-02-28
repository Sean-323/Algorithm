import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 입력
        char[] arr = br.readLine().toCharArray();
        int[] numbers = new int[arr.length];

        // 로직
        for (int i = 0; i < arr.length; i++) numbers[i] = arr[i] - '0';
        Arrays.sort(numbers);

        for (int i = arr.length - 1; i >= 0; i--) sb.append(numbers[i]);


        // 출력
        System.out.println(sb);
    }
}