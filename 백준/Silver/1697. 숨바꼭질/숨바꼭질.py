from collections import deque

def dfs(n, k):
    max_point = 10 ** 5
    visited = [False] * (max_point + 1)
    queue = deque([(n, 0)]) # 현재 위치, 시간

    while queue:
        current, time = queue.popleft()

        if current == k:
            return time
        for next in (current -1, current + 1, current * 2):
            if 0 <= next <= max_point and not visited[next]:
                visited[next] = True
                queue.append((next, time + 1))

n, k = map(int, input().split())
print(dfs(n, k))