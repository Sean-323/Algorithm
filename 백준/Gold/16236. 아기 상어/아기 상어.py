from collections import deque

# 입력 받기
n = int(input())
grid = [list(map(int, input().split())) for _ in range(n)]

# 방향 설정 (위, 아래, 왼쪽, 오른쪽)
directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]

# 아기 상어의 초기 위치 찾기
for i in range(n):
    for j in range(n):
        if grid[i][j] == 9:
            shark_pos = (i, j)
            grid[i][j] = 0  # 초기 위치를 비워둠

# BFS를 사용하여 가장 가까운 물고기 찾기
def bfs(start, size):
    visited = [[False] * n for _ in range(n)]
    queue = deque([(start[0], start[1], 0)])  # (행, 열, 거리)
    visited[start[0]][start[1]] = True
    fish = []
    
    while queue:
        r, c, dist = queue.popleft()
        
        for dr, dc in directions:
            nr, nc = r + dr, c + dc
            
            if 0 <= nr < n and 0 <= nc < n and not visited[nr][nc]:
                if grid[nr][nc] <= size:
                    visited[nr][nc] = True
                    queue.append((nr, nc, dist + 1))
                    if 0 < grid[nr][nc] < size:
                        fish.append((dist + 1, nr, nc))
    
    if fish:
        fish.sort()
        return fish[0]
    else:
        return None

# 시뮬레이션
shark_size = 2
shark_eaten = 0
total_time = 0

while True:
    result = bfs(shark_pos, shark_size)
    
    if not result:
        break
    
    distance, fish_r, fish_c = result
    total_time += distance
    shark_pos = (fish_r, fish_c)
    grid[fish_r][fish_c] = 0
    shark_eaten += 1
    
    if shark_eaten == shark_size:
        shark_size += 1
        shark_eaten = 0

print(total_time)