import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 입력
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        char[] dna = br.readLine().toCharArray();

        int[] need = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) need[i] = Integer.parseInt(st.nextToken());

        int[] cnt = new int[4];
        int satisfied = 0;

        // 로직
        for (int i = 0; i < 4; i++) {
            if (need[i] == 0) satisfied++;
        }

        for (int i = 0; i < P; i++) satisfied += add(cnt, need, dna[i]);

        int answer = (satisfied == 4) ? 1 : 0;

        for (int i = P; i < S; i++) {
            satisfied += remove(cnt, need, dna[i - P]);
            satisfied += add(cnt, need, dna[i]);

            if (satisfied == 4) answer++;
        }

        // 출력
        System.out.println(answer);
    }

    static int add(int[] cnt, int[] need, char ch) {
        int idx = idx(ch);
        cnt[idx]++;
        return (cnt[idx] == need[idx]) ? 1 : 0;
    }

    static int remove(int[] cnt, int[] need, char ch) {
        int idx = idx(ch);
        int delta = (cnt[idx] == need[idx]) ? -1 : 0;
        cnt[idx]--;
        return delta;
    }

    static int idx(char ch) {
        switch (ch) {
            case 'A': return 0;
            case 'C': return 1;
            case 'G': return 2;
            default:  return 3;
        }
    }
}