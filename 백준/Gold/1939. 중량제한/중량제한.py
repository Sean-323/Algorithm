from collections import deque

def bfs(graph, start, end, weight_limit, n):
    queue = deque([start])
    visited = [False] * (n + 1)
    visited[start] = True
    
    while queue:
        current = queue.popleft()
        
        if current == end:
            return True
        
        for neighbor, weight in graph[current]:
            if not visited[neighbor] and weight >= weight_limit:
                visited[neighbor] = True
                queue.append(neighbor)
    
    return False

def find_max_weight(n, bridges, start, end):
    graph = [[] for _ in range(n + 1)]
    for u, v, w in bridges:
        graph[u].append((v, w))
        graph[v].append((u, w))
    
    low, high = 1, max(w for _, _, w in bridges)
    
    while low <= high:
        mid = (low + high) // 2
        if bfs(graph, start, end, mid, n):
            low = mid + 1
        else:
            high = mid - 1
    
    return high

import sys
input = sys.stdin.read
data = input().split()

n, m = int(data[0]), int(data[1])
bridges = [(int(data[i]), int(data[i+1]), int(data[i+2])) for i in range(2, 3*m+2, 3)]
start_island, end_island = int(data[-2]), int(data[-1])

print(find_max_weight(n, bridges, start_island, end_island))