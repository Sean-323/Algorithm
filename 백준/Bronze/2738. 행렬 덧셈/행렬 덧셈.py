import sys as s
a, b = map(int, s.stdin.readline().split())

a_list = []
b_list = []

for row in range(a):
    row = list(map(int, s.stdin.readline().split()))
    a_list.append(row)

for row in range(a):
    row = list(map(int, s.stdin.readline().split()))
    b_list.append(row)

for i in range(a):
    for j in range(b):
        print(a_list[i][j] + b_list[i][j], end=' ')
    print()