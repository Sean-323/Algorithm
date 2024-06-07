import sys as s
n = int(s.stdin.readline().strip())
arr = list(map(int, s.stdin.readline().strip().split()))
arr.sort()

max_num = arr[-1]

omit_num = 1
arr_set = set(arr)
while omit_num in arr_set:
    omit_num += 1

print(omit_num)