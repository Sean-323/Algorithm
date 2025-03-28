import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
 
        for (int tc = 1; tc <= T; tc++) {
            int[] numbers = new int[10];
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
 
            for (int i = 0; i < 10; i++) {
                numbers[i] = Integer.parseInt(st.nextToken().trim());
            }
            Arrays.sort(numbers);
            int total = 0;
 
            for (int i = 1; i < numbers.length - 1; i++) {
                total += numbers[i];
            }
 
            int avg = Math.round((float) total / 8); // 반올림 처리
            System.out.println("#" + tc + " " + avg);
 
        }
    }
}