from collections import deque
import sys

input = sys.stdin.read
data = input().strip().split()

n = int(data[0])
x = int(data[1])
y = int(data[2])
m = int(data[3])

edges = []
index = 4
for _ in range(m):
    a = int(data[index])
    b = int(data[index + 1])
    edges.append((a, b))
    index += 2

def bfs(start, end, n, edges):
    graph = [[] for _ in range(n + 1)]
    
    # 간선 정보 입력
    for a, b in edges:
        graph[a].append(b)
        graph[b].append(a)
    
    # BFS 초기화
    visited = [-1] * (n + 1)
    queue = deque([(start, 0)])  # (현재 정점, 촌수)
    visited[start] = 0
    
    while queue:
        current, dist = queue.popleft()
        
        if current == end:
            return dist
        
        for neighbor in graph[current]:
            if visited[neighbor] == -1:
                visited[neighbor] = dist + 1
                queue.append((neighbor, dist + 1))
    
    return -1  # 연결되지 않음

result = bfs(x, y, n, edges)
print(result)