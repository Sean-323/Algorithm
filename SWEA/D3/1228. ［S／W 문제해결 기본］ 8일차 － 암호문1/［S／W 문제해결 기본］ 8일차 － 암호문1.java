import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
 
class Solution{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int tc = 1; tc <= 10; tc++) { 
            int N = Integer.parseInt(br.readLine().trim()); 
            LinkedList<Integer> list = new LinkedList<>();
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            for (int i = 0; i < N; i++) {
                list.add(Integer.parseInt(st.nextToken()));
            }
            int M = Integer.parseInt(br.readLine().trim());
            st = new StringTokenizer(br.readLine().trim());
            while (st.hasMoreTokens()) {
                String command = st.nextToken(); 
                int X = Integer.parseInt(st.nextToken()); 
                int Y = Integer.parseInt(st.nextToken()); 
                List<Integer> subList = new ArrayList<>();
                for (int i = 0; i < Y; i++) {
                    subList.add(Integer.parseInt(st.nextToken()));
                }
                if (X >= 0 && X <= list.size()) {
                    list.addAll(X, subList);
                }
            }
            bw.write("#" + tc);
            for (int i = 0; i < Math.min(10, list.size()); i++) {
                bw.write(" " + list.get(i));
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}