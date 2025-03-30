import java.io.*;
import java.util.*;
 
class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
         
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
             
            List<Integer>[] g = new List[N + 1];
            for(int i = 1; i <= N; i++) g[i] = new ArrayList<>();
             
            while (M-- > 0) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                g[a].add(b); g[b].add(a);
            }
             
            boolean[] v = new boolean[N + 1];
            v[1] = true;
            int cnt = 0;
             
            for (int f : g[1]) {
                if (!v[f]) { v[f] = true; cnt++; }
                for (int ff : g[f])
                    if (!v[ff]) { v[ff] = true; cnt++; }
            }
             
            sb.append("#").append(tc).append(" ").append(cnt).append("\n");
        }
        System.out.print(sb);
    }
}