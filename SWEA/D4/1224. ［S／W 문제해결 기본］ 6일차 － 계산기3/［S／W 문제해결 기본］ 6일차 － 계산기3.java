import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
 
class Solution{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int tc = 1; tc <= 10; tc++) {
            StringBuilder out = new StringBuilder();
            Stack<Character> stack = new Stack<>();
            int N = Integer.parseInt(br.readLine().trim());
            String infix = br.readLine().trim();
            for (char ch : infix.toCharArray()) {
                if ('0' <= ch &&  ch <= '9') out.append(ch);
                else if (ch == '(') stack.push(ch);
                else if (ch == '*' || ch == '/') {
                    if (!stack.isEmpty() && (stack.peek() == '*' || stack.peek() == '/')) out.append(stack.pop());
                    stack.push(ch);
                }
                else if (ch == '+' || ch == '-') {
                    while (!stack.isEmpty() && stack.peek() != '(') out.append(stack.pop());
                    stack.push(ch);
                }
                else if (ch == ')') {
                    while (!stack.isEmpty() && stack.peek() != '(') out.append(stack.pop());
                    stack.pop();
                }
            }
            while (!stack.isEmpty()) out.append(stack.pop());
            Stack<Integer> stack2 = new Stack<>();
            for (char ch : out.toString().toCharArray()) {
                if ('0' <= ch && ch <= '9') stack2.push(ch - '0');
                else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                    int a = stack2.pop();
                    int b = stack2.pop();
                    int result = 0;
                    switch (ch) {
                        case '+' : result = b + a; break;
                        case '-' : result = b - a; break;
                        case '*' : result = b * a; break;
                        case '/' : result = b / a; break;
                    }
                    stack2.push(result);
                }
            }
            int result = stack2.pop();
            bw.write("#" + tc + " " + result + "\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }
}