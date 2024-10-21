import sys
sys.setrecursionlimit(10**6)

def dfs(node):
    visited[node] = True
    for x in graph[node]:
        if not visited[x]:
            dfs(x)

n, m = map(int, sys.stdin.readline().split())

graph = [[] for _ in range(n+1)]

for _ in range(m):
    a, b = map(int, sys.stdin.readline().split())
    graph[a].append(b)
    graph[b].append(a)

visited = [False for _ in range(n + 1)]

ans = 0

for i in range(1, n+1):
    if not visited[i]:
        ans += 1
        dfs(i)

print(ans)