# 입력 받기
import sys
input = sys.stdin.readline

N, K = map(int, input().split())
heights = list(map(int, input().split()))

# 인접한 학생들의 키 차이를 계산하여 저장
gaps = [heights[i+1] - heights[i] for i in range(N - 1)]

# 키 차이 리스트를 내림차순 정렬 후, 큰 차이를 K-1개 제외
gaps.sort(reverse=True)

# 최소 비용 계산
min_cost = sum(gaps[K-1:])

print(min_cost)