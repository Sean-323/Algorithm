import sys as s
str = s.stdin.readline().strip()

for i in range(0, len(str), 10):
    print(str[i:i+10])