import sys as s
from itertools import permutations

n = int(s.stdin.readline().strip())
k = int(s.stdin.readline().strip())
numbers = [s.stdin.readline().strip() for _ in range(n)]

arr = set()

for perm in permutations(numbers, k):
    number_str = ''.join(perm)
    arr.add(number_str)

print(len(arr))