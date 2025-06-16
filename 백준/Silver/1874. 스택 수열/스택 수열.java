import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(br.readLine()); 
        int[] sequence = new int[n];

        for (int i = 0; i < n; i++) sequence[i] = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        int current = 1; 
        boolean possible = true;

        for (int i = 0; i < n; i++) {
            int target = sequence[i];

            while (current <= target) {
                stack.push(current);
                sb.append("+\n");
                current++;
            }

            if (stack.peek() == target) {
                stack.pop();
                sb.append("-\n");
            } else {
                possible = false;
                break;
            }
        }

        System.out.print(possible ? sb : "NO\n");
    }
}