n = int(input())
board = [[0] * n for _ in range(n)]
liker = [[] for _ in range(n * n + 1)]
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

for _ in range(n * n):
    a, b, c, d, e = map(int, input().split())
    liker[a] = [b, c, d, e]

    max_like, max_empty = -1, -1 # 최대 좋아하는 학생 수, 최대 주변 비어있는 칸 수. 초깃값은 -1로 설정할게요.
    for i in range(n):
        for j in range(n):
            if board[i][j] == 0:
                like, empty = 0, 0 # 현재 좋아하는 학생 수, 현재 주변 비어있는 칸 수
                for d in range(4):
                    ni, nj = i + dx[d], j + dy[d]
                    if 0 <= ni < n and 0 <= nj < n:
                        if board[ni][nj] in liker[a]:
                            like += 1
                        elif board[ni][nj] == 0:
                            empty += 1
                if like > max_like or (like == max_like and empty > max_empty): # 갱신 조건 확인하기
                    x, y, max_like, max_empty = i, j, like, empty
    board[x][y] = a

ans = 0
for i in range(n):
    for j in range(n):
        cnt = 0
        for d in range(4):
            ni, nj = i + dx[d], j + dy[d]
            if 0 <= ni < n and 0 <= nj < n and board[ni][nj] in liker[board[i][j]]:
                cnt += 1
        ans += 10 ** (cnt - 1) if cnt else 0 # 0이면 0점, 1~4는 1, 10, 100, 1000점
print(ans)