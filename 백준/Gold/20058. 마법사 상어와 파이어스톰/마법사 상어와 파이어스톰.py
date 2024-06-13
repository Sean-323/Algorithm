# 스톰
def storm(level):
    def rotate(x, y):
        target = [board[x + dx][y:y + side] for dx in range(side)]
        for nx in range(side):
            for ny in range(side):
                board[x + nx][y + ny] = target[side - ny - 1][nx]

    side = 2 ** level
    for ii in range(0, N, side):
        for jj in range(0, N, side):
            rotate(ii, jj)


# 파이어
def fire():
    melt = []
    for x in range(N):
        for y in range(N):
            if board[x][y]:
                adj = 0
                for d in range(4):
                    nx = x + dx[d]
                    ny = y + dy[d]
                    if 0 <= nx < N and 0 <= ny < N and board[nx][ny]:
                        adj += 1
                if adj < 3:
                    melt.append((x, y))
    for mx, my in melt:
        board[mx][my] -= 1


# BFS
def bfs(x, y):
    if not board[x][y]:
        return 0
    queue = [(x, y)]
    visited[x][y] = True
    for nx, ny in queue:
        for d in range(4):
            mx = nx + dx[d]
            my = ny + dy[d]
            if 0 <= mx < N and 0 <= my < N and not visited[mx][my] and board[mx][my]:
                queue.append((mx, my))
                visited[mx][my] = True
    return len(queue)


# Input
n, q = map(int, input().split())
N = 2 ** n
board = [list(map(int, input().split())) for _ in range(N)]
order = list(map(int, input().split()))
dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

# 파이어 스톰
for o in order:
    if o:
        storm(o)
    fire()

# 가장 큰 얼음 찾기
remain = 0
ans = 0
visited = [[False] * N for _ in range(N)]
for j in range(N):
    for k in range(N):
        if board[j][k]:
            remain += board[j][k]
            if not visited[j][k]:
                ans = max(ans, bfs(j, k))

# 답 출력
print(remain)
print(ans)