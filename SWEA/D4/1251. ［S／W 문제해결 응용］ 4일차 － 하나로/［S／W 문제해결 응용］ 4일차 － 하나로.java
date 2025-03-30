import java.io.*;
import java.util.*;
 
public class Solution {
    static class Edge {
        int u, v;
        long cost;
 
        public Edge(int u, int v, long cost) {
            this.u = u;
            this.v = v;
            this.cost = cost;
        }
    }
 
    static int[] parent;
 
    static void makeSet(int N) {
        parent = new int[N + 1];
        for (int i = 0; i < parent.length; i++) parent[i] = i;
    }
 
    static int findSet(int x) {
        if (parent[x] == x) return x;
        return parent[x] = findSet(parent[x]);
    }
 
    static void union(int x, int y) {
        int rootX = findSet(x);
        int rootY = findSet(y);
        parent[rootY] = rootX;
    }
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
 
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringBuilder sb = new StringBuilder();
            sb.append("#").append(tc).append(" ");
 
            int N = Integer.parseInt(br.readLine());
            int[] arr1 = new int[N];
            int[] arr2 = new int[N];
 
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) arr1[i] = Integer.parseInt(st.nextToken());
             
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) arr2[i] = Integer.parseInt(st.nextToken());
 
            double E = Double.parseDouble(br.readLine());
 
            List<Edge> edges = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                for (int j = i + 1; j < N; j++) {
                    int ix = arr1[i];
                    int jx = arr1[j];
                    int iy = arr2[i];
                    int jy = arr2[j];
                    long radius = (long) (ix - jx) * (ix - jx) + (long) (iy - jy) * (iy - jy);
                    edges.add(new Edge(i, j, radius));
                }
            }
 
            edges.sort((o1, o2) -> Long.compare(o1.cost, o2.cost));
 
            makeSet(N);
            int cnt = 0;
            long total = 0;
            for (Edge edge : edges) {
                if (findSet(edge.u) != findSet(edge.v)) {
                    union(edge.u, edge.v);
                    total += edge.cost;
                    cnt++;
                    if (cnt == N - 1) break;
                }
            }
            long result = Math.round(total * E);
             
            sb.append(result);
            bw.write(sb.toString());
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }
}