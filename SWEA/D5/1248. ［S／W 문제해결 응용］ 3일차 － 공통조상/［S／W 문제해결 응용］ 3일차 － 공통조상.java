import java.io.*;
import java.util.StringTokenizer;
 
public class Solution {
 
    static class Node {
        int parentIdx, leftChildIdx, rightChildIdx;
    }
 
    static int V, E, Node1, Node2, size; // 노드의 개수 / 간선의 개수 / 공통 조상을 찾을 두 노드 / 공통 조상을 루트로 하는 서브 트리의 크기
    static Node[] tree; // 트리를 표현하는 배열
    static boolean[] visited; // 공통 조상 찾을 때 방문 여부 체크용 배열
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
 
        int T = Integer.parseInt(br.readLine().trim());
 
        for (int tc = 1; tc <= T; tc++) {
            StringBuilder sb = new StringBuilder();
            sb.append("#").append(tc).append(" ");
 
            // 입력
            st = new StringTokenizer(br.readLine().trim());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            Node1 = Integer.parseInt(st.nextToken());
            Node2 = Integer.parseInt(st.nextToken());
 
            tree = new Node[V + 1];
            visited = new boolean[V + 1];
 
            // 로직
            for (int i = 1; i <= V; i++) {
                tree[i] = new Node();
            }
 
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < E; i++) {
                int parent = Integer.parseInt(st.nextToken());
                int child = Integer.parseInt(st.nextToken());
 
                if (tree[parent].leftChildIdx == 0) tree[parent].leftChildIdx = child;
                else tree[parent].rightChildIdx = child;
 
                tree[child].parentIdx = parent;
            }
 
            int commonParent = findCommonParent(Node1, Node2);
            size = 0;
            calculateSubtreeSize(commonParent);
            sb.append(commonParent).append(" ").append(size).append("\n");
 
            bw.write(sb.toString());
        }
 
        bw.flush();
        bw.close();
        br.close();
    }
 
    static int findCommonParent(int node1, int node2) {
        boolean[] visited = new boolean[V + 1];
        while (node1 != 0) {
            visited[node1] = true;
            node1 = tree[node1].parentIdx;
        }
        while (node2 != 0) {
            if (visited[node2]) return node2;
            node2 = tree[node2].parentIdx;
        }
        return 1; // 루트 노드가 공통 조상인 경우
    }
 
    static void calculateSubtreeSize(int idx) {
        size++;
        if (tree[idx].leftChildIdx != 0) calculateSubtreeSize(tree[idx].leftChildIdx);
        if (tree[idx].rightChildIdx != 0) calculateSubtreeSize(tree[idx].rightChildIdx);
    }
}