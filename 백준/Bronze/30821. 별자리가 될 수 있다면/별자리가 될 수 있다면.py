import sys
from itertools import combinations

input = sys.stdin.read
n = int(input().strip())
numbers = range(1, n + 1)
count = sum(1 for _ in combinations(numbers, 5))

print(count)