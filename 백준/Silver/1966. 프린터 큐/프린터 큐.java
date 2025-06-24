import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            Queue<int[]> queue = new LinkedList<>();
            int[] priorities = new int[n];

            for (int i = 0; i < n; i++) {
                int priority = sc.nextInt();
                queue.offer(new int[]{i, priority});
                priorities[i] = priority;
            }

            Arrays.sort(priorities);
            int priorityIndex = n - 1;

            int count = 0;

            while (!queue.isEmpty()) {
                int[] front = queue.poll();
                int index = front[0];
                int priority = front[1];

                if (priority == priorities[priorityIndex]) {
                    count++;
                    priorityIndex--;

                    if (index == m) {
                        sb.append(count).append("\n");
                        break;
                    }
                } else {
                    queue.offer(front);
                }
            }
        }

        System.out.println(sb);
    }

}
