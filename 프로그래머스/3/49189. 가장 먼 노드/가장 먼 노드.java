import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        // 1. 그래프 만들기
        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] e : edge) {
            int a = e[0];
            int b = e[1];
            graph[a].add(b);
            graph[b].add(a); // 무향 그래프
        }

        // 2. BFS 준비
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1); // 방문 안한 곳은 -1
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1); // 시작은 1번 노드
        dist[1] = 0;

        // 3. BFS 탐색
        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int next : graph[now]) {
                if (dist[next] == -1) {
                    dist[next] = dist[now] + 1;
                    queue.offer(next);
                }
            }
        }

        // 4. 가장 먼 거리 구하고, 그 거리의 노드 개수 세기
        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, dist[i]);
        }

        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == max) count++;
        }

        return count;
    }
}