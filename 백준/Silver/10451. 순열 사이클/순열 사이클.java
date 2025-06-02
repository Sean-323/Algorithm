import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    static void dfs(int node, boolean[] visited, int[] permutation) {
        while (!visited[node]) {
            visited[node] = true;
            node = permutation[node];
        }
    }

    static int countCycles(int n, int[] permutation) {
        boolean[] visited = new boolean[n + 1];
        int cycles = 0;
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                dfs(i, visited, permutation);
                cycles++;
            }
        }
        return cycles;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] allInput = br.lines().toArray(String[]::new);
        int t = Integer.parseInt(allInput[0]);
        StringBuilder sb = new StringBuilder();

        int idx = 1;
        for (int test = 0; test < t; test++) {
            int n = Integer.parseInt(allInput[idx]);
            int[] permutation = new int[n + 1];
            String[] nums = allInput[idx + 1].split(" ");
            for (int i = 1; i <= n; i++) {
                permutation[i] = Integer.parseInt(nums[i - 1]);
            }
            idx += 2;
            sb.append(countCycles(n, permutation)).append("\n");
        }

        System.out.print(sb);
    }
}