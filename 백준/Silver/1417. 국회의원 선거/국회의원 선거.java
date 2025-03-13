import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        int dasom = Integer.parseInt(br.readLine());
        
        // N이 1인 경우 다솜이 유일한 후보이므로 매수가 필요없음
        if (N == 1) {
            bw.write("0");
            bw.flush();
            bw.close();
            br.close();
            return;
        }
        
        // 다른 후보들의 투표 수를 저장
        ArrayList<Integer> others = new ArrayList<>();
        for (int i = 0; i < N - 1; i++) {
            others.add(Integer.parseInt(br.readLine()));
        }
        
        int votes = 0;
        
        // 최다 득표를 할 때까지 반복
        while (!others.isEmpty() && dasom <= Collections.max(others)) {
            int maxVotes = Collections.max(others);
            int maxIdx = others.indexOf(maxVotes);
            others.set(maxIdx, maxVotes - 1);
            dasom += 1;
            votes += 1;
        }
        
        bw.write(String.valueOf(votes));
        bw.flush();
        bw.close();
        br.close();
    }
}