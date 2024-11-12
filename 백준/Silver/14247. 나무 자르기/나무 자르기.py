import sys
input = sys.stdin.readline

# 입력 받기
N = int(input())
initial_heights = list(map(int, input().split()))
growth_rates = list(map(int, input().split()))

# 나무를 (속도, 초기 높이)로 묶어 정렬
trees = sorted(zip(growth_rates, initial_heights))

# 최소 비용 계산
total_cost = 0
for day, (growth_rate, initial_height) in enumerate(trees):
    total_cost += initial_height + day * growth_rate

# 결과 출력
print(total_cost)