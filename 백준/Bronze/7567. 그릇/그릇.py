import sys as s
str = s.stdin.readline().strip()
sum = 10

for i in range(len(str) - 1):
    if str[i] == str[i+1]:
        sum += 5
    else:
        sum += 10
print(sum)
