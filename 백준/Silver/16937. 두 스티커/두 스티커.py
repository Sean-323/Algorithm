import sys

# 3. 스티커 2종을 가로, 세로로 붙일 때 모눈종이에 붙일 수 있는지 판단하는 함수
def check_available(r1, r2, c1, c2):
    # 스티커를 세로로 나란히 붙일 경우
    if (c1 + c2) <= W and max(r1, r2) <= H:
        return True
    # 스티커를 가로로 나란히 붙일 경우
    if (r1 + r2) <= H and max(c1, c2) <= W:
        return True
    return False

# 1. 문제의 input을 받습니다.
H, W = map(int, sys.stdin.readline().split())
N = int(sys.stdin.readline())
stickers = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]

ans = 0
# 2. 스티커 중 2가지를 고르는 모든 경우의 수를 탐색합니다.
for i in range(N):
    for j in range(i + 1, N):
        # 첫 번째 스티커의 가로 세로
        r1, c1 = stickers[i]
        # 두 번째 스티커의 가로 세로
        r2, c2 = stickers[j]
        
        # 4. 각 스티커 2종에 대해 모눈종이에 붙일 수 있는지 판단하고, 정답을 업데이트 합니다. 
        # 모두 회전하지 않은 경우
        if check_available(r1, r2, c1, c2):
            ans = max(ans, r1 * c1 + r2 * c2)
        # 첫 스티커만 90도 회전할 경우
        if check_available(c1, r2, r1, c2):
            ans = max(ans, r1 * c1 + r2 * c2)
        # 두 번째 스티커만 90도 회전할 경우
        if check_available(r1, c2, c1, r2):
            ans = max(ans, r1 * c1 + r2 * c2)
        # 두 개 모두 90도 회전할 경우
        if check_available(c1, c2, r1, r2):
            ans = max(ans, r1 * c1 + r2 * c2)

print(ans)