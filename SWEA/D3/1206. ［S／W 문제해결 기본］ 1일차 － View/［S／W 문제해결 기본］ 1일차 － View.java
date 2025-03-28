import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
class Solution{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int tc = 1; tc <= 10; tc++) {
            int N = Integer.parseInt(br.readLine().trim());
            int[] apts = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            for (int i = 0; i < N; i++) {
                apts[i] = Integer.parseInt(st.nextToken());
            }
            int total = 0;
            for (int i = 2; i < apts.length - 2; i++) {
                if (apts[i] > apts[i - 2] && apts[i] > apts[i - 1] && apts[i] > apts[i + 1] && apts[i] > apts[i + 2]) {
                    int firstNum = Math.max(Math.max(Math.max(apts[i - 2], apts[i - 1]),apts[i + 1]),apts[i + 2]);
                    total += (apts[i] - firstNum);
                }
            }
            System.out.println("#" + tc + " " + total);
        }
    }
}