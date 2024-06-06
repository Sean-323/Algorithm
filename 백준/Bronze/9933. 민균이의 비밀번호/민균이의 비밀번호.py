import sys as s
n = int(s.stdin.readline().strip())
arr = []
reverse_arr = []

for i in range(n):
    arr.append(str(s.stdin.readline().strip()))
    reverse_arr.append(arr[i][::-1])

for i in arr:
    for j in reverse_arr:
        if i == j:
            a = i
            length = len(a)
            middle_char = a[length//2]
            print(length, middle_char)
            exit()