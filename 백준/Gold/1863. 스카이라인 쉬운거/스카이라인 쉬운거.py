import sys as s

n = int(s.stdin.readline())
result = 0
skylines = []

for i in range(n):
    skylines.append(int(s.stdin.readline().split()[1]))

skylines.append(0)

arr = [0]

for i in skylines:
    height = i
    while arr[-1] > i:
        if arr[-1] != height:
            result += 1
            height = arr[-1]
        arr.pop()
    arr.append(i)

print(result)