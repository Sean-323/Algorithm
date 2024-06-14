import heapq
import sys
input = sys.stdin.read
INF = int(1e9)

def dijkstra(start, graph, n):
    distances = [INF] * (n + 1)
    distances[start] = 0
    pq = [(0, start)]
    while pq:
        current_distance, current_node = heapq.heappop(pq)
        if current_distance > distances[current_node]:
            continue
        for adjacent, weight in graph[current_node]:
            distance = current_distance + weight
            if distance < distances[adjacent]:
                distances[adjacent] = distance
                heapq.heappush(pq, (distance, adjacent))
    return distances

def main():
    input = sys.stdin.read
    data = input().split()
    
    N = int(data[0])
    E = int(data[1])
    
    graph = [[] for _ in range(N + 1)]
    
    index = 2
    for _ in range(E):
        a = int(data[index])
        b = int(data[index + 1])
        c = int(data[index + 2])
        graph[a].append((b, c))
        graph[b].append((a, c))
        index += 3
    
    v1 = int(data[index])
    v2 = int(data[index + 1])
    
    dist_start = dijkstra(1, graph, N)
    dist_v1 = dijkstra(v1, graph, N)
    dist_v2 = dijkstra(v2, graph, N)
    
    path1 = dist_start[v1] + dist_v1[v2] + dist_v2[N]
    path2 = dist_start[v2] + dist_v2[v1] + dist_v1[N]
    
    result = min(path1, path2)
    
    if result >= INF:
        print(-1)
    else:
        print(result)

if __name__ == "__main__":
    main()