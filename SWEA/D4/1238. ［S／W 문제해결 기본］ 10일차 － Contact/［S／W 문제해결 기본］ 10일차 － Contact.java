import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class Solution {
    static int N;
    static List<Integer>[] adj;
    static boolean[] visited;
 
    public static void main(String[] args) throws IOException {
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        int T = 10;
 
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
 
            N = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            visited = new boolean[101];
            adj = new ArrayList[101];
 
            for (int i = 1; i <= 100; i++) {
                adj[i] = new ArrayList<>();
            }
 
            // 길이 N
            String[] strArr = br.readLine().trim().split(" ");
 
            // 간선 정보 입력
            // 페어니까 N/2
            for (int i = 0; i < N / 2; i++) {
                int A = Integer.parseInt(strArr[i * 2]);
                int B = Integer.parseInt(strArr[i * 2 + 1]);
 
                adj[A].add(B);
            }
 
            int result = bfs(start);
            System.out.println("#" + tc + " " + result);
        }
    }
 
    private static int bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;
        List<List<Integer>> nums = new ArrayList<>();
 
        int depth = 0;
 
        while (!q.isEmpty()) {
            int size = q.size();
 
            List<Integer> currentNums = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                int num = q.poll();
                 
                currentNums.add(num);
 
                // 꺼낸 정점과 연결된 애들한테 연락하기 위해서
                // visited 하지 않은 정점에 연락
                for (int j = 0; j < adj[num].size(); j++) {
                    int nextNode = adj[num].get(j);
                    // 이미 연락한 정점이면 넘어가기
                    if (visited[nextNode])
                        continue;
 
                    q.add(nextNode);
                    visited[nextNode] = true;
                }
            }
             
            if(!currentNums.isEmpty()) {
                nums.add(currentNums);
                depth++;
            }
        }
        List<Integer> last = nums.get(depth-1);
        Collections.sort(last);
         
        return last.get(last.size()-1);
    }
}