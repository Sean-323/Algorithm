import sys
input = sys.stdin.readline

# 입력 받기
R, C = map(int, input().split())
obsNum = int(input())

# 격자 초기화
grid = [[0] * C for _ in range(R)]
for _ in range(obsNum):
    r, c = map(int, input().split())
    grid[r][c] = 1  # 벽 설정

# 초기 로봇 위치
sr, sc = map(int, input().split())
grid[sr][sc] = 1  # 로봇이 방문한 곳 표시

# 이동 우선순위와 방향 벡터 설정
directions = list(map(int, input().split()))
for i in range(4):
    directions[i] -= 1  # 0-indexed로 변환
dr = [-1, 1, 0, 0]  # 북, 남, 서, 동
dc = [0, 0, -1, 1]

# 로봇 이동
pos = 0
visited_directions = set()
while True:
    visited_directions.add(directions[pos])
    nr, nc = sr + dr[directions[pos]], sc + dc[directions[pos]]

    # 이동 불가능한 경우
    if nr < 0 or nr >= R or nc < 0 or nc >= C or grid[nr][nc] == 1:
        pos = (pos + 1) % 4  # 다음 방향으로 전환
        if directions[pos] in visited_directions:  # 모든 방향이 막혔을 경우
            break
    else:
        # 이동 가능: 위치 업데이트
        visited_directions.clear()
        grid[nr][nc] = 1
        sr, sc = nr, nc

# 결과 출력
print(sr, sc)