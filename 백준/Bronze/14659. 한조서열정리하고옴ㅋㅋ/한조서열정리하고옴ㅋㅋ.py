import sys as s

n = int(s.stdin.readline().strip())
archer = list(map(int, s.stdin.readline().strip().split()))

high = 0
count = 0
result = []

for i in archer:
    if i > high:
        high = i
        count = 0
    else:
        count += 1
    result.append(count)
print(max(result))