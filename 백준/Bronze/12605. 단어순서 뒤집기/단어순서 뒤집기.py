import sys as s
n = int(s.stdin.readline().strip())

arr = [s.stdin.readline().strip().split() for _ in range(n)]

for i in range(n):
    arr[i].reverse()
    print("Case #{}: {}".format(i+1, ' '.join(arr[i])))