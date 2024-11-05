import sys, itertools

N, S = map(int, sys.stdin.readline().split())
arr = list(map(int, sys.stdin.readline().split()))
result = 0

for i in range(1, N + 1):
    for comb in itertools.combinations(arr, i):
        if sum(comb) == S:
            result += 1

print(result)