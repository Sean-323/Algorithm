import sys
input = sys.stdin.readline

# 입력 받기
N = int(input())
R = int(input())
candidates = list(map(int, input().split()))

# 사진틀 (후보 번호를 키로, [추천 수, 게시 시간]을 값으로 관리)
frame = {}
time = 0  # 게시 시간 (후보가 게시된 순서)

for candidate in candidates:
    if candidate in frame:
        # 이미 게시된 후보라면 추천 수 증가
        frame[candidate][0] += 1
    else:
        # 새로운 후보인 경우
        if len(frame) == N:
            # 사진틀이 꽉 찬 경우, 추천 수와 게시 시간 기준으로 제거
            to_remove = min(frame.items(), key=lambda x: (x[1][0], x[1][1]))
            del frame[to_remove[0]]
        
        # 새로운 후보 추가
        frame[candidate] = [1, time]
    time += 1

# 남아있는 후보를 오름차순으로 정렬하여 출력
print(" ".join(map(str, sorted(frame.keys()))))