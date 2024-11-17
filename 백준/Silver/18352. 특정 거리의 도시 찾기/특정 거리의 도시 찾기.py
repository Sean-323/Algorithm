from collections import deque
import sys
input = sys.stdin.readline

# 입력 받기
N, M, K, X = map(int, input().split())
graph = {i: [] for i in range(1, N + 1)}

for _ in range(M):
    A, B = map(int, input().split())
    graph[A].append(B)

# 최단 거리 계산을 위한 BFS
def bfs(start):
    distances = [-1] * (N + 1)  # 모든 노드의 거리를 -1로 초기화
    distances[start] = 0  # 시작 노드의 거리는 0
    queue = deque([start])
    
    while queue:
        current = queue.popleft()
        for neighbor in graph[current]:
            if distances[neighbor] == -1:  # 방문하지 않은 노드
                distances[neighbor] = distances[current] + 1
                queue.append(neighbor)
    
    return distances

# BFS를 통해 최단 거리 계산
distances = bfs(X)

# 최단 거리가 K인 모든 노드 찾기
result = [i for i in range(1, N + 1) if distances[i] == K]

# 결과 출력
if result:
    print("\n".join(map(str, sorted(result))))
else:
    print(-1)