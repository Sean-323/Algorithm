import sys as s
input = s.stdin.readline

def char_to_num(char):
    return ord(char) - 96

n = int(input().strip())
str = input().strip()
arr = []
sum = 0

for i in str:
    arr.append(char_to_num(i))

for i in range(n):
    sum += arr[i] * (31 ** i)
    
print(sum)