import sys
import heapq
input = sys.stdin.readline

def dijkstra(start, n, graph):
    # 최소 비용을 저장할 배열
    distances = [float('inf')] * (n + 1)
    distances[start] = 0
    pq = [(0, start)]  # (비용, 노드)

    while pq:
        current_cost, current_node = heapq.heappop(pq)
        
        # 이미 처리된 노드라면 건너뛴다
        if distances[current_node] < current_cost:
            continue
        
        # 인접 노드를 탐색
        for neighbor, cost in graph[current_node]:
            new_cost = current_cost + cost
            if new_cost < distances[neighbor]:
                distances[neighbor] = new_cost
                heapq.heappush(pq, (new_cost, neighbor))
    
    return distances

# 입력 받기
n = int(input())
m = int(input())
graph = {i: [] for i in range(1, n + 1)}

for _ in range(m):
    a, b, c = map(int, input().split())
    graph[a].append((b, c))

start, end = map(int, input().split())

# 다익스트라 알고리즘 실행
distances = dijkstra(start, n, graph)

# 결과 출력
print(distances[end])