import sys
input = sys.stdin.readline

# 입력 받기
n = int(input())
expected_ranks = [int(input()) for _ in range(n)]

# 기대 등수를 정렬
expected_ranks.sort()

# 실제 등수를 정렬된 순서대로 배정하며 차이를 계산
total_difference = 0
for actual_rank, expected_rank in enumerate(expected_ranks, start=1):
    total_difference += abs(expected_rank - actual_rank)

# 결과 출력
print(total_difference)