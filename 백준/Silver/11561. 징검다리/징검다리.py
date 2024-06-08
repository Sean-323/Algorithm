import sys
import math

def max_jumps(n):
    if n < 1:
        return 0
    k = int((-1 + math.sqrt(1 + 8 * n)) / 2)
    return k

n = int(sys.stdin.readline().strip())
arr = []
for _ in range(n):
    arr.append(int(sys.stdin.readline().strip()))

for i in arr:
    print(max_jumps(i))