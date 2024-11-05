import sys, itertools

N, S = map(int, sys.stdin.readline().split())
arr = list(map(int, sys.stdin.readline().split()))

# 모든 길이의 조합을 한 번에 체크하며 S와 일치하는 부분합 개수 구하기
result = sum(1 for i in range(1, N + 1) for comb in itertools.combinations(arr, i) if sum(comb) == S)

print(result)