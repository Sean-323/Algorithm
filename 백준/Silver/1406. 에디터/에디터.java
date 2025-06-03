import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        Stack<Character> leftStack = new Stack<>();   // 커서 왼쪽
        Stack<Character> rightStack = new Stack<>();  // 커서 오른쪽

        String temp = br.readLine().trim();
        for (char c : temp.toCharArray()) {
            leftStack.push(c);
        }

        int N = Integer.parseInt(br.readLine().trim());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine().trim());
            String command = st.nextToken();

            switch (command) {
                case "L":  
                    if (!leftStack.isEmpty()) rightStack.push(leftStack.pop());
                    break;
                    
                case "D":  
                    if (!rightStack.isEmpty())  leftStack.push(rightStack.pop());
                    break;
                    
                case "B":  
                    if (!leftStack.isEmpty()) leftStack.pop();
                    break;
                    
                case "P":  
                    char c = st.nextToken().charAt(0);
                    leftStack.push(c);
                    break;
            }
        }
        
        while (!leftStack.isEmpty()) rightStack.push(leftStack.pop());
        
        while (!rightStack.isEmpty()) sb.append(rightStack.pop());
        
        System.out.println(sb);
    }
}