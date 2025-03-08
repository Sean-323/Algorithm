import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int result = 0;
        
        for (int len = 1; len <= N; len++) result += countCombinations(arr, 0, 0, len, S, 0);
        
        bw.write(String.valueOf(result));
        bw.newLine();
        bw.flush();
        bw.close();
        br.close();
    }
    
    private static int countCombinations(int[] arr, int start, int depth, int r, int targetSum, int currentSum) {
        // 조합이 완성된 경우
        if (depth == r) {
            return currentSum == targetSum ? 1 : 0;
        }
        
        int count = 0;
        
        // 현재 위치부터 시작하여 조합 생성
        for (int i = start; i < arr.length; i++) {
            // 현재 요소를 선택하고 다음 요소로 진행
            count += countCombinations(arr, i + 1, depth + 1, r, targetSum, currentSum + arr[i]);
        }
        
        return count;
    }
}