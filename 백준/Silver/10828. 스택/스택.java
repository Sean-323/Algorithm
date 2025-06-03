import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine().trim());
            String command = st.nextToken();

            switch (command) {
                case "push":
                    int value = Integer.parseInt(st.nextToken());
                    stack.push(value);
                    break;

                case "top":
                    sb.append(stack.isEmpty() ? -1 : stack.peek()).append("\n");
                    break;

                case "size":
                    sb.append(stack.size()).append("\n");
                    break;

                case "empty":
                    sb.append(stack.isEmpty() ? 1 : 0).append("\n");
                    break;

                case "pop":
                    sb.append(stack.isEmpty() ? -1 : stack.pop()).append("\n");
            }
        }

        System.out.println(sb);
    }
}