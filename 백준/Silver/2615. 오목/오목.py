import sys
input = sys.stdin.readline

def omok(board, x, y, color):
    directions = [(0, 1), (1, 0), (1, 1), (-1, 1)]
    for dx, dy in directions:
        count = 1
        nx, ny = x + dx, y + dy
        while 0 <= nx < 19 and 0 <= ny < 19 and board[nx][ny] == color:
            count += 1
            nx += dx
            ny += dy
        nx, ny = x - dx, y - dy
        while 0 <= nx < 19 and 0 <= ny < 19 and board[nx][ny] == color:
            count += 1
            nx -= dx
            ny -= dy
        if count == 5:
            prev_x, prev_y = x - dx, y - dy
            next_x, next_y = x + 5*dx, y + 5*dy
            if not (0 <= prev_x < 19 and 0 <= prev_y < 19 and board[prev_x][prev_y] == color) and \
                    not (0 <= next_x < 19 and 0 <= next_y < 19 and board[next_x][next_y] == color):
                return True
    return False

board = [list(map(int, input().split())) for _ in range(19)]

for x in range(19):
    for y in range(19):
        if board[x][y] != 0:
            if omok(board, x, y, board[x][y]):
                print(board[x][y])
                print(x + 1, y + 1)
                sys.exit()
print(0)