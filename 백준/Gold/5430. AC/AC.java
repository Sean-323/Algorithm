import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());

        int T = Integer.parseInt(st.nextToken());

        for (int i = 0; i < T; i++) {
            // 입력
            st = new StringTokenizer(br.readLine().trim());
            String commands = st.nextToken();

            st = new StringTokenizer(br.readLine().trim());
            int n = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine().trim());
            String input = st.nextToken();

            input = input.substring(1, input.length() - 1);
            Deque<Integer> deque = new ArrayDeque<>();

            if (!input.isEmpty()) {
                String[] parts = input.split(",");
                for (String s : parts) deque.add(Integer.parseInt(s));
            }

            // 로직
            boolean isReversed = false;
            boolean isError = false;

            for (char c : commands.toCharArray()) {
                if (c == 'R') isReversed = !isReversed;
                else if (c == 'D') {
                    if (deque.isEmpty()) {
                        isError = true;
                        break;
                    }

                    if (isReversed) deque.pollLast();
                    else deque.pollFirst();
                }
            }

            if (isError) {
                System.out.println("error");
                continue;
            }

            // 출력
            StringBuilder sb = new StringBuilder();
            sb.append("[");

            while (!deque.isEmpty()) {

                if (isReversed) sb.append(deque.pollLast());
                else sb.append(deque.pollFirst());
                if (!deque.isEmpty()) sb.append(",");
            }
            sb.append("]");
            System.out.println(sb);
        }
    }

}