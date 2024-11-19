import sys
from collections import defaultdict

input = sys.stdin.readline
sys.setrecursionlimit(100000)

def dfs(node, parent):
    global is_cycle
    visited[node] = True

    for neighbor in graph[node]:
        if not visited[neighbor]:
            dfs(neighbor, node)
        elif neighbor != parent:
            is_cycle = True

case = 1
while True:
    n, m = map(int, input().split())
    if n == 0 and m == 0:
        break

    graph = defaultdict(list)
    visited = [False] * (n + 1)
    tree_count = 0

    for _ in range(m):
        u, v = map(int, input().split())
        graph[u].append(v)
        graph[v].append(u)

    for node in range(1, n + 1):
        if not visited[node]:
            is_cycle = False
            dfs(node, -1)
            if not is_cycle:
                tree_count += 1

    if tree_count == 0:
        print(f"Case {case}: No trees.")
    elif tree_count == 1:
        print(f"Case {case}: There is one tree.")
    else:
        print(f"Case {case}: A forest of {tree_count} trees.")
    
    case += 1