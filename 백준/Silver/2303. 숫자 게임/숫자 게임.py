from itertools import combinations

n = int(input())
result = []

for _ in range(n):
    numbers = list(map(int, input().split()))
    result.append(max(sum(comb) % 10 for comb in combinations(numbers, 3)))

max_num = max(result)
max_idx = n - result[::-1].index(max_num)

print(max_idx)