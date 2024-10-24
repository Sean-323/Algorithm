from collections import deque

def bfs(start):
    visited = [False] * (n + 1)
    visited[start] = True
    queue = deque([(start, 0)])
    count = 0

    while queue:
        person, depth = queue.popleft()

        if depth >= 2:
            continue
        for friend in graph[person]:
            if not visited[friend]:
                visited[friend] = True
                count += 1
                queue.append((friend, depth + 1))

    return count

n = int(input())
m = int(input())

graph = [[] for _ in range(n + 1)]

for _ in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

print(bfs(1))