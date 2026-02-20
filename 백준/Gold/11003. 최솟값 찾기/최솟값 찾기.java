import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int idx;
        int val;
        Node(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Deque<Node> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(st.nextToken());

            while(!deque.isEmpty() && deque.peekLast().val > x) deque.pollLast();

            deque.addLast(new Node(i, x));

            while (!deque.isEmpty() && deque.peekFirst().idx <= i - L) deque.pollFirst();

            sb.append(deque.peekFirst().val).append(" ");
        }
        System.out.println(sb);
    }
}
