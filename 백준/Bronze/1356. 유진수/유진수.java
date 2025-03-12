import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        
        boolean isSpecial = false;
        // 가능한 모든 분할 위치에 대해 왼쪽, 오른쪽 곱 계산
        for (int i = 1; i < s.length(); i++) {
            long leftProduct = 1;
            long rightProduct = 1;
            
            // 왼쪽 부분의 곱 계산
            for (int j = 0; j < i; j++) {
                leftProduct *= (s.charAt(j) - '0');
            }
            // 오른쪽 부분의 곱 계산
            for (int j = i; j < s.length(); j++) {
                rightProduct *= (s.charAt(j) - '0');
            }
            
            if (leftProduct == rightProduct) {
                isSpecial = true;
                break;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(isSpecial ? "YES" : "NO");
        
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
