import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[9];

        for (int i = 0; i < 9; i++) arr[i] = Integer.parseInt(br.readLine());

        int[] temp = arr.clone();
        Arrays.sort(temp);

        int target = temp[8];
        int result = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) result = i + 1;
        }
        System.out.println(target);
        System.out.println(result);
    }
}
