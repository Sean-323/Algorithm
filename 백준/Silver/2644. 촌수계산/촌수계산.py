from collections import deque

def bfs(start, end, graph, n):
    visited = [-1] * (n + 1)
    queue = deque([(start, 0)])
    visited[start] = 0

    while queue:
        current, dist = queue.popleft()

        if current == end:
            return dist
        
        for neighbor in graph[current]:
            if visited[neighbor] == -1:
                visited[neighbor] = dist + 1
                queue.append((neighbor, dist + 1))

    return -1

n = int(input().strip())
x, y = map(int, input().strip().split())
m = int(input().strip())

graph = [[] for _ in range(n + 1)]

for _ in range(m):
    a, b = map(int, input().strip().split())
    graph[a].append(b)
    graph[b].append(a)

result = bfs(x, y, graph, n)
print(result)