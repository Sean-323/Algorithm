from collections import deque

n, k = map(int, input().split())
friends = [int(input()) for _ in range(n)]

def bfs(start, target):
    queue = deque([(start, 0)])
    visited = [False] * n

    while queue:
        current, count = queue.popleft()

        if current == target:
            return count
        if not visited[current]:
            visited[current] = True
            queue.append((friends[current], count + 1))
    
    return -1

print(bfs(0, k))