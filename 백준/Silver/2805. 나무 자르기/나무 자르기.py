import sys as s
N, M = map(int, s.stdin.readline().split())
arr = list(map(int, s.stdin.readline().split()))

left, right = 0, max(arr)
result = 0

while left <= right:
    mid = (left + right) // 2
    total = 0
    for h in arr:
        if h > mid:
            total += h - mid

    if total >= M:
        result = mid
        left = mid + 1
    else:
        right = mid - 1

print(result)