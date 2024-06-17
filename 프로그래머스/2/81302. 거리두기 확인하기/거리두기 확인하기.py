def solution(places):
    answer = []
    for place in places:
        answer.append(check(place))
    return answer


def check(board):
    dx = [1, -1, 0, 0]
    dy = [0, 0, 1, -1]

    for x in range(5):
        for y in range(5):
            # 사람이 있는 경우 탐색을 시작해요
            if board[x][y] == "P":
                for d in range(4):
                    nx = x + dx[d]
                    ny = y + dy[d]
                    if 0 <= nx < 5 and 0 <= ny < 5:
                        # 바로 옆에 사람이 있는 경우 0을 반환해요
                        if board[nx][ny] == "P":
                            return 0
                        # 비어있는 경우, 주변의 다른 칸에 사람이 있는지 확인해요
                        if board[nx][ny] == "O":
                            for dd in range(4):
                                nnx = nx + dx[dd]
                                nny = ny + dy[dd]
                                if x == nnx and y == nny:
                                    continue
                                if 0 <= nnx < 5 and 0 <= nny < 5:
                                    if board[nnx][nny] == "P":
                                        return 0
    return 1
