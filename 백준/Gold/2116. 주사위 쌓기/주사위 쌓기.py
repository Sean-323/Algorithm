import sys
input = sys.stdin.readline

# 입력 받기
N = int(input())
dices = [list(map(int, input().split())) for _ in range(N)]

# 각 면의 마주 보는 면 인덱스 설정
opposite = {0: 5, 1: 3, 2: 4, 3: 1, 4: 2, 5: 0}

max_sum = 0

# 첫 번째 주사위의 아랫면을 모든 면으로 설정하며 최대 합을 구한다
for start_face in range(6):
    total = 0
    current_bottom = dices[0][start_face]
    current_top = dices[0][opposite[start_face]]
    
    # 첫 주사위에서 윗면, 아랫면을 제외한 나머지 면 중 최대 값 선택
    total += max([dices[0][i] for i in range(6) if i != start_face and i != opposite[start_face]])
    
    # 두 번째 주사위부터는 위의 주사위의 윗면이 현재 주사위의 아랫면이 된다
    for i in range(1, N):
        current_bottom = current_top
        current_top_index = dices[i].index(current_bottom)
        current_top = dices[i][opposite[current_top_index]]
        
        # 현재 주사위에서 윗면과 아랫면을 제외한 네 면 중 최대 값 선택
        total += max([dices[i][j] for j in range(6) if j != current_top_index and j != opposite[current_top_index]])
    
    # 최대 합 갱신
    max_sum = max(max_sum, total)

print(max_sum)