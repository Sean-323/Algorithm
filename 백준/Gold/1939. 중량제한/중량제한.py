from collections import deque

def bfs(graph, start, end, weight_limit):
    queue = deque([start])
    visited = set()
    visited.add(start)
    
    while queue:
        current = queue.popleft()
        
        if current == end:
            return True
        
        for neighbor, weight in graph[current]:
            if neighbor not in visited and weight >= weight_limit:
                visited.add(neighbor)
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
        if bfs(graph, start, end, mid):
            low = mid + 1
        else:
            high = mid - 1
    
    return high

# 입력 받기
import sys
input = sys.stdin.read
data = input().split()

n, m = int(data[0]), int(data[1])
bridges = []

index = 2
for _ in range(m):
    u, v, w = int(data[index]), int(data[index + 1]), int(data[index + 2])
    bridges.append((u, v, w))
    index += 3

start_island = int(data[index])
end_island = int(data[index + 1])

# 최대 중량 출력
print(find_max_weight(n, bridges, start_island, end_island))