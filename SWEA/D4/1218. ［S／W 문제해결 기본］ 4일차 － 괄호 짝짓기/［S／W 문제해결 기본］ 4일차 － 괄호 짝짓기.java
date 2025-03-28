import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
 
class Solution{
public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int tc = 1; tc <= 10; tc++) {
            int N = Integer.parseInt(br.readLine().trim());
            String input = br.readLine().trim();
            boolean isValid = isValidBrackets(input);
            bw.write("#" + tc + " " + (isValid ? 1 : 0) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
    private static boolean isValidBrackets(String input) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> matchingBrackets = new HashMap<>();
        matchingBrackets.put(')', '(');
        matchingBrackets.put('}', '{');
        matchingBrackets.put(']', '[');
        matchingBrackets.put('>', '<');
        for (char c : input.toCharArray()) {
            if (matchingBrackets.containsValue(c)) {
                stack.push(c);
            } else if (matchingBrackets.containsKey(c)) {
                if (stack.isEmpty() || stack.pop() != matchingBrackets.get(c)) return false;
            }
        }
        return stack.isEmpty();
    }
}