import math

t = int(input())
result = []

for _ in range(t):
    n, m = map(int, input().split())
    result.append(math.comb(m, n))

for i in result:
    print(i)
