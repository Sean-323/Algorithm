import sys
input = sys.stdin.read

board = [list(map(int, line.split())) for line in input().strip().splitlines()]

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

unique_numbers = set()

def dfs(x, y, number):
    if len(number) == 6:
        unique_numbers.add(number)
        return

    for i in range(4):
        nx, ny = x + dx[i], y + dy[i]
        if 0 <= nx < 5 and 0 <= ny < 5:
            dfs(nx, ny, number + str(board[nx][ny]))

for i in range(5):
    for j in range(5):
        dfs(i, j, str(board[i][j]))

print(len(unique_numbers))