import sys
input = sys.stdin.read
sys.setrecursionlimit(10 ** 6)

def dfs(graph, start):
    visited = [False] * len(graph)
    order = [0] * len(graph)
    stack = [start]
    cnt = 1

    while stack:
        node = stack.pop()
        if not visited[node]:
            visited[node] = True
            order[node] = cnt
            cnt += 1
            for next_node in sorted(graph[node], reverse=True):
                if not visited[next_node]:
                    stack.append(next_node)

    return order

data = input().split()
N, M, R = int(data[0]), int(data[1]), int(data[2])

graph = [[] for _ in range(N + 1)]
index = 3

for _ in range(M):
    u, v = int(data[index]), int(data[index + 1])
    graph[u].append(v)
    graph[v].append(u)
    index += 2

order = dfs(graph, R)

for i in range(1, N + 1):
    print(order[i])