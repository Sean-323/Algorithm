import java.io.*;
import java.util.*;
 
class Solution{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine().trim());
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine().trim());
            LinkedList<String> cards = new LinkedList<>();
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            while (st.hasMoreTokens()) cards.add(st.nextToken());
            LinkedList<String> result = new LinkedList<>();
            int mid = (N + 1) / 2;
            Iterator<String> leftIter = cards.subList(0, mid).iterator();
            Iterator<String> rightIter = cards.subList(mid, N).iterator();
            while (leftIter.hasNext() || rightIter.hasNext()) {
                if (leftIter.hasNext()) result.add(leftIter.next());
                if (rightIter.hasNext()) result.add(rightIter.next());
            }
            bw.write("#" + tc + " " + String.join(" ", result) + " \n");
        }
        br.close();
        bw.flush();
        bw.close();
    }
}