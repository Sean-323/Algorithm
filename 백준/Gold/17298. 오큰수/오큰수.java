import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 입력
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] ans = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) A[i] = Integer.parseInt(st.nextToken());

        // 로직
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && A[stack.peek()] < A[i]) ans[stack.pop()]  = A[i];
            stack.push(i);
        }

        while (!stack.isEmpty()) ans[stack.pop()] = -1;

        for (int i = 0; i < N; i++) sb.append(ans[i]).append(" ");

        // 출력
        System.out.println(sb);
    }
}
