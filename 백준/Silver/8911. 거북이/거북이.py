import sys as s

def turtle(command):
    x, y = 0, 0  # 현재 위치
    direction = 0  # # 0: 북, 1: 동, 2: 남, 3: 서 (리스트 위치별 방향)

    dx = [0, 1, 0, -1]  # 북 : 0 동 : 1 남 : 0 서 : -1
    dy = [1, 0, -1, 0]

    visited = [(x, y)]

    for c in command:
        if c == 'F':
            x += dx[direction]
            y += dy[direction]
        elif c == 'B':
            x -= dx[direction]
            y -= dy[direction]
        elif c == 'L':
            direction = (direction + 3) % 4
        elif c == 'R':
            direction = (direction + 1) % 4
        visited.append((x, y))

    # •	direction = (direction + 3) % 4: 왼쪽으로 90도 회전
    # •	현재 방향에서 3을 더하고 4로 나눈 나머지를 계산합니다. 이는 시계 반대 방향으로 90도 회전한 효과를 줍니다.
    # •	예: 방향이 북쪽(0)일 때, (0 + 3) % 4 = 3이므로 서쪽(3)이 됩니다.
    # •	direction = (direction + 1) % 4: 오른쪽으로 90도 회전
    # •	현재 방향에서 1을 더하고 4로 나눈 나머지를 계산합니다. 이는 시계 방향으로 90도 회전한 효과를 줍니다.
    # •	예: 방향이 북쪽(0)일 때, (0 + 1) % 4 = 1이므로 동쪽(1)이 됩니다.

    # x 좌표의 최소값을 구합니다.
    min_x = min(v[0] for v in visited)  # v[0]은 각 튜플의 첫 번째 요소, 즉 x 값을 의미합니다.
    # x 좌표의 최대값을 구합니다.
    max_x = max(v[0] for v in visited)  # v[0]은 각 튜플의 첫 번째 요소, 즉 x 값을 의미합니다.
    # y 좌표의 최소값을 구합니다.
    min_y = min(v[1] for v in visited)  # v[1]은 각 튜플의 두 번째 요소, 즉 y 값을 의미합니다.
    # y 좌표의 최대값을 구합니다.
    max_y = max(v[1] for v in visited)  # v[1]은 각 튜플의 두 번째 요소, 즉 y 값을 의미합니다.

    area = (max_x - min_x) * (max_y - min_y)
    return area

n = int(s.stdin.readline().strip())
command = [s.stdin.readline().strip() for _ in range(n)]
result = []

for i in command:
    result.append(str(turtle(i)))

print('\n'.join(result))