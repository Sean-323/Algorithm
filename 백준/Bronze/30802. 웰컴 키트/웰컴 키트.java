import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long N = Long.parseLong(br.readLine().trim());

        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] sizes = new long[6];
        for (int i = 0; i < 6; i++) sizes[i] = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine());
        long T = Long.parseLong(st.nextToken());
        long P = Long.parseLong(st.nextToken());

        long tshirtBundles = 0;
        for (int i = 0; i < 6; i++) {
            tshirtBundles += (sizes[i] + T - 1) / T; 
        }

        StringBuilder sb = new StringBuilder();
        sb.append(tshirtBundles).append('\n');
        sb.append(N / P).append(' ').append(N % P);

        System.out.print(sb.toString());
    }
}