import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 입력
        int N = Integer.parseInt(br.readLine().trim());
        st = new StringTokenizer(br.readLine().trim());
        Set<Integer> numSet = new HashSet<>();
        for (int i = 0; i < N; i++) numSet.add(Integer.parseInt(st.nextToken()));

        int M = Integer.parseInt(br.readLine().trim());
        st = new StringTokenizer(br.readLine().trim());
        
        // 로직
        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());
            sb.append(numSet.contains(target) ? 1 : 0).append("\n");
        }

        // 출력
        System.out.println(sb);
    }
}