from collections import deque
import sys

input = sys.stdin.read

def bfs(l, start, end):
    directions = [(-2, -1), (-1, -2), (1, -2), (2, -1), (2, 1), (1, 2), (-1, 2), (-2, 1)]
    board = [[-1] * l for _ in range(l)]
    queue = deque([start])
    board[start[0]][start[1]] = 0

    while queue:
        x, y = queue.popleft()

        if (x, y) == end:
            return board[x][y]

        for dx, dy in directions:
            nx, ny = x + dx, y + dy

            if 0 <= nx < l and 0 <= ny < l and board[nx][ny] == -1:
                board[nx][ny] = board[x][y] + 1
                queue.append((nx, ny))

    return -1  # 이 경우는 실제로 발생하지 않음

# 입력 처리
data = input().split()
index = 0
T = int(data[index])
index += 1

results = []
for _ in range(T):
    l = int(data[index])
    index += 1
    start_x, start_y = int(data[index]), int(data[index + 1])
    index += 2
    end_x, end_y = int(data[index]), int(data[index + 1])
    index += 2
    result = bfs(l, (start_x, start_y), (end_x, end_y))
    results.append(result)

for res in results:
    print(res)