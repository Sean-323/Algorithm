import sys

# 1. 문제의 입력을 받습니다.
# 1-1. 빙고판을 입력 받습니다.
arr = []
for _ in range(5):
    arr.append(sys.stdin.readline().split())

# 1-2. 2차원배열로 입력되는 사회자가 부르는 수를 하나의 list에 담습니다.
num = []
for _ in range(5):
    list = sys.stdin.readline().split()
    for i in list:
        num.append(i)

# 2. 빙고판을 초기화 합니다.
check_board = [[False for _ in range(5)] for _ in range(5)]


# 3. 빙고 수를 체크할 수 있는 함수를 구현합니다.

# 3-1. 빙고 row 수를 확인하기 위한 함수를 구현합니다.
def check_row_bingo():
    count = 0
    for i in range(5):
        is_bingo = True
        for j in range(5):
            if not check_board[i][j]:
                is_bingo = False
                break
        if is_bingo:
            count += 1
    return count

# 3-2. 빙고 column 수를 확인하기 위한 함수를 구현합니다.
def check_column_bingo():
    count = 0
    for j in range(5):
        is_bingo = True
        for i in range(5):
            if not check_board[i][j]:
                is_bingo = False
                break
        if is_bingo:
            count += 1
    return count


# 3-3. 대각선 빙고 수를 확인하기 위한 함수를 구현합니다.
def check_diagonal_bingo():
    count = 0
    # \ 모양 대각선
    is_bingo = True
    for i in range(5):
        if not check_board[i][i]:
            is_bingo = False
            break;
    if is_bingo:
        count += 1

    # / 모양 대각선
    is_bingo = True
    for i in range(5):
        if not check_board[i][4 - i]:
            is_bingo = False
            break
    if is_bingo:
        count += 1

    return count

# 4. 사회자가 부르는 각 수에 대해 빙고판을 True로 체크하고, 만족하는 빙고의 수를 확인합니다.
for i in range(25):
    now_num = num[i]
    # 4-1. 사회자가 부른 숫자의 빙고판 위치를 확인하고, 그 위치를 True로 표기합니다.
    for x in range(5):
        for y in range(5):
            if arr[x][y] == now_num:
                check_board[x][y] = True
    # 4-2. 빙고판을 True로 체크한 이후 빙고가 몇개 완성되었는지 확인합니다.
    count = check_row_bingo() + check_column_bingo() + check_diagonal_bingo()
    # 5. 완성된 빙고의 개수가 3개 이상이라면 해당 순서를 출력하고 탈출합니다.
    if count >= 3:
        print(i+1)
        break
