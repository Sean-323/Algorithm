import sys
input = sys.stdin.readline

# 입력 받기
R, C = map(int, input().split())
grid = [list(input().strip()) for _ in range(R)]

# 상하좌우 탐색 방향
directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]

# 바다로 변할 위치를 저장할 리스트
to_change = []

# 바다로 변할 섬 확인
for r in range(R):
    for c in range(C):
        if grid[r][c] == 'X':
            sea_count = 0
            for dr, dc in directions:
                nr, nc = r + dr, c + dc
                if nr < 0 or nr >= R or nc < 0 or nc >= C or grid[nr][nc] == '.':
                    sea_count += 1
            if sea_count >= 3:
                to_change.append((r, c))

# 섬을 바다로 변환
for r, c in to_change:
    grid[r][c] = '.'

# 남아있는 섬의 영역 확인
min_row, max_row = R, 0
min_col, max_col = C, 0

for r in range(R):
    for c in range(C):
        if grid[r][c] == 'X':
            min_row = min(min_row, r)
            max_row = max(max_row, r)
            min_col = min(min_col, c)
            max_col = max(max_col, c)

# 남아있는 영역 출력
for r in range(min_row, max_row + 1):
    print("".join(grid[r][min_col:max_col + 1]))