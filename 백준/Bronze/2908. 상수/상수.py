import sys
a, b = map(str, sys.stdin.readline().split())

num_list = []
num_list.append(a[::-1])
num_list.append(b[::-1])

print(max(num_list))