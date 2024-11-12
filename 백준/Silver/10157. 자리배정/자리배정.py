import sys
input = sys.stdin.readline

# 입력 받기
C, R = map(int, input().split())
K = int(input())

# K가 전체 좌석 수보다 크면 배정 불가
if K > C * R:
    print(0)
    sys.exit()

# 반시계 방향 순서: 아래, 오른쪽, 위, 왼쪽
dx = [0, 1, 0, -1]
dy = [-1, 0, 1, 0]

# 공연장 좌석 초기화
seating = [[0] * C for _ in range(R)]
x, y = 0, R - 1  # 시작 위치 (1, 1) == (0, R - 1)
direction = 0    # 시작 방향: 아래

# K번째 좌석까지 배정
for num in range(1, K + 1):
    seating[y][x] = num  # 현재 위치에 대기 번호 배정
    
    # K번째 좌석에 도달하면 출력하고 종료
    if num == K:
        print(x + 1, R - y)
        break

    # 다음 위치 계산
    nx, ny = x + dx[direction], y + dy[direction]

    # 경계 체크 및 방문 확인
    if 0 <= nx < C and 0 <= ny < R and seating[ny][nx] == 0:
        x, y = nx, ny
    else:
        # 이동 불가하면 방향 전환
        direction = (direction + 1) % 4
        x, y = x + dx[direction], y + dy[direction]