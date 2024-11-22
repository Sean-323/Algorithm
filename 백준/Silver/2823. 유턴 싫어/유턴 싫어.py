import sys
input = sys.stdin.readline

# 입력 받기
R, C = map(int, input().split())
grid = [list(input().strip()) for _ in range(R)]

# 방향 벡터 (상, 하, 좌, 우)
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def is_uturn_required():
    for x in range(R):
        for y in range(C):
            if grid[x][y] == '.':
                # 인접 도로 칸의 개수 확인
                adjacent_roads = 0
                for i in range(4):
                    nx, ny = x + dx[i], y + dy[i]
                    if 0 <= nx < R and 0 <= ny < C and grid[nx][ny] == '.':
                        adjacent_roads += 1
                
                # 유턴 조건 확인
                if adjacent_roads <= 1:
                    return True
    return False

# 결과 출력
print(1 if is_uturn_required() else 0)