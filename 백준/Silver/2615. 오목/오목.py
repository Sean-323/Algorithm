import sys
input = sys.stdin.readline

def check_winner(board, x, y, color):
    # 방향: 가로, 세로, 대각선(오른쪽 아래), 대각선(오른쪽 위)
    directions = [(0, 1), (1, 0), (1, 1), (-1, 1)]
    for dx, dy in directions:
        count = 1
        # 한 방향으로 체크
        nx, ny = x + dx, y + dy
        while 0 <= nx < 19 and 0 <= ny < 19 and board[nx][ny] == color:
            count += 1
            nx += dx
            ny += dy
        # 반대 방향으로 체크
        nx, ny = x - dx, y - dy
        while 0 <= nx < 19 and 0 <= ny < 19 and board[nx][ny] == color:
            count += 1
            nx -= dx
            ny -= dy
        # 연속된 돌의 개수가 정확히 5개인 경우
        if count == 5:
            # 시작점과 끝점이 정확히 5개의 돌을 포함하는지 확인
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
            if check_winner(board, x, y, board[x][y]):
                print(board[x][y])
                print(x + 1, y + 1)
                sys.exit()
print(0)
