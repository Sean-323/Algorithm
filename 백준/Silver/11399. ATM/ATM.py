import sys as s

n = int(s.stdin.readline().strip())
arr = list(map(int, s.stdin.readline().strip().split()))

arr.sort()
min_time = 0
total_time = 0

for i in range(n):
    total_time += arr[i]
    min_time += total_time

print(min_time)