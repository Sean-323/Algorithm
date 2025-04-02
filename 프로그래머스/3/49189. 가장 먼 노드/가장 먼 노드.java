import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        // 1. 그래프 만들기
        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] e : edge) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]); // 무향 그래프
        }

        // 2. BFS 탐색 - 최적화된 방식
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1); // 방문 안한 곳은 -1

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1); // 시작은 1번 노드
        dist[1] = 0;

        int maxDist = 0;
        int count = 0;

        // 3. BFS 탐색하면서 최대 거리 계산
        while (!queue.isEmpty()) {
            int now = queue.poll();

            if (dist[now] > maxDist) {
                maxDist = dist[now];
                count = 1;
            } else if (dist[now] == maxDist) {
                count++;
            }

            for (int next : graph[now]) {
                if (dist[next] == -1) {
                    dist[next] = dist[now] + 1;
                    queue.offer(next);
                }
            }
        }

        // 마지막 레벨의 노드들만 카운트 반환
        return count - (maxDist == 0 ? 1 : 0); // 시작 노드 제외
    }
}