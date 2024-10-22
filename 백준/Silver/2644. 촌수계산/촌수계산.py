from collections import deque

def bfs(start, end, graph, n):
    visited = [-1] * (n + 1)  # 방문 여부 체크 및 촌수 계산을 위한 리스트
    queue = deque([(start, 0)])  # (현재 노드, 현재 촌수)
    visited[start] = 0  # 시작 노드는 촌수 0으로 표시
    
    while queue:
        current, dist = queue.popleft()
        
        if current == end:
            return dist  # 목표 노드에 도착하면 현재 촌수 반환
        
        for neighbor in graph[current]:
            if visited[neighbor] == -1:  # 방문하지 않은 노드만 탐색
                visited[neighbor] = dist + 1
                queue.append((neighbor, dist + 1))
    
    return -1  # 목표 노드에 도달하지 못하면 -1 반환

# 입력 처리
n = int(input().strip())  # 전체 사람 수
x, y = map(int, input().strip().split())  # 촌수를 계산해야 할 두 사람
m = int(input().strip())  # 부모-자식 관계의 수

graph = [[] for _ in range(n + 1)]  # 그래프 초기화

# 부모-자식 관계 입력
for _ in range(m):
    a, b = map(int, input().strip().split())
    graph[a].append(b)
    graph[b].append(a)  # 무방향 그래프로 간선 추가

# BFS를 통해 촌수 계산
result = bfs(x, y, graph, n)
print(result)