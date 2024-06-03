import sys as s
arr = []
result = ""

for line in s.stdin:
    arr.append(line.strip())

max_length = max(len(row) for row in arr)

for i in range(max_length):
    for row in arr:
        if i < len(row): # 입력된 값의 길이가 다 달라서 하는 것
            result += row[i]

print(result)