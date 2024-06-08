import math
import sys as s

def max_k(N):
    return int((-1 + math.sqrt(1 + (8 * N))) // 2)

num = int(s.stdin.readline().strip())
result = []

for i in range(num):
    result.append(int(s.stdin.readline().strip()))

for i in result:
    print(max_k(i))