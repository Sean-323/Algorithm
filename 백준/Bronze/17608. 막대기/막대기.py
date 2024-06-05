n = int(input().strip())
arr = [int(input()) for _ in range(n)]

stand = arr[-1]
count = 1

for i in reversed(range(n)):
    if arr[i] > stand:
        count += 1
        stand = arr[i]

print(count)