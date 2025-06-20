import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        // 입력: N과 B를 공백으로 구분하여 읽음
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int B = Integer.parseInt(input[1]);

        // N이 0인 경우는 예외 처리
        if(N == 0) {
            sb.append("0");
        } else {
            StringBuilder result = new StringBuilder();
            while(N > 0) {
                int remainder = N % B; // 나머지 계산
                N /= B;              // N을 B로 나눔
                // 나머지가 10 미만이면 '0'~'9', 10 이상이면 'A'부터 사용
                if(remainder < 10) {
                    result.append((char)('0' + remainder));
                } else {
                    result.append((char)('A' + remainder - 10));
                }
            }
            // 반복문으로 구한 결과는 역순이므로 reverse()
            sb.append(result.reverse());
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
