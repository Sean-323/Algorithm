import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution{
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            int N = Integer.parseInt(br.readLine().trim());
            int[] numbers = new int[100];
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            for (int j = 0; j < 100; j++) {
                numbers[j] = Integer.parseInt(st.nextToken().trim());
            }
            Arrays.sort(numbers);
            for (int j = 0; j < N; j++) {
                if (numbers[99] - numbers[0] == 0 || numbers[99] - numbers[0] == 1) {
                    break;
                }
                ++numbers[0];
                --numbers[99];
                Arrays.sort(numbers);
            }
            System.out.println("#" + (i + 1) + " " + (numbers[99] - numbers[0]));
        }
    }
}