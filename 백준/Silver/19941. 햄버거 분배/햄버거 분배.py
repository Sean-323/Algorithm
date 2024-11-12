import sys
import bisect

# 입력 받기
N, K = map(int, sys.stdin.readline().split())
seats = sys.stdin.readline().strip()

# 햄버거의 위치를 저장
hamburger_positions = []
for idx, seat in enumerate(seats):
    if seat == 'H':
        hamburger_positions.append(idx)

# 햄버거 위치를 리스트로 관리 (정렬되어 있음)
# 할당된 햄버거의 위치를 관리하기 위해 set 사용
assigned_hamburgers = set()

result = 0

# 사람의 위치를 순서대로 탐색
for i, seat in enumerate(seats):
    if seat == 'P':
        # 가능한 햄버거의 범위: i-K ~ i+K
        left = i - K
        right = i + K

        # 이분 탐색을 통해 할당 가능한 햄버거의 시작 인덱스 찾기
        start_idx = bisect.bisect_left(hamburger_positions, left)

        # 가능한 햄버거 중 가장 왼쪽에 있는 할당되지 않은 햄버거 찾기
        for j in range(start_idx, len(hamburger_positions)):
            if hamburger_positions[j] > right:
                break  # 범위를 벗어나면 더 이상 확인할 필요 없음
            if hamburger_positions[j] not in assigned_hamburgers:
                assigned_hamburgers.add(hamburger_positions[j])
                result += 1
                break  # 한 사람당 한 햄버거만 할당

print(result)