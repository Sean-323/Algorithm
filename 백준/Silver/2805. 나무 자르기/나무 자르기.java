import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        int maxHeight = 0;
        
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            maxHeight = Math.max(maxHeight, arr[i]);
        }
        
        int left = 0;
        int right = maxHeight;
        int result = 0;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            long total = 0;
            
            for (int h : arr) {
                if (h > mid) {
                    total += (h - mid);
                }
            }
            
            if (total >= M) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        System.out.println(result);
    }
}