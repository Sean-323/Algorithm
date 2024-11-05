import sys
import itertools

n, s = map(int, sys.stdin.readline().split())
arr1 = list(map(int, sys.stdin.readline().split()))

result = 0

for i in range(1, n + 1):
    for combination in itertools.combinations(arr1, i):
        if sum(combination) == s:
            result += 1

print(result)