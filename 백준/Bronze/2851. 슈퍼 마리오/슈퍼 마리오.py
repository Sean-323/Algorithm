# 10개의 버섯 점수를 입력받음
mushrooms = [int(input()) for _ in range(10)]

# 현재 점수의 누적합과 100에 가장 가까운 점수 초기화
total = 0
closest = 0

# 각 버섯 점수에 대해 반복
for mushroom in mushrooms:
    # 현재 누적 점수에 버섯 점수 추가
    total += mushroom
    
    # 현재 누적 점수와 100 사이의 차이가 closest와 100 사이의 차이보다 작거나 같으면 closest 갱신
    if abs(100 - total) <= abs(100 - closest):
        closest = total

# 100에 가장 가까운 누적 점수 출력
print(closest)