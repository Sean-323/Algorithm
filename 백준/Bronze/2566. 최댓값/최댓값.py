import sys
input = sys.stdin.read

# 입력 읽기
data = input().split()

# 9x9 배열 초기화
arr = []
index = 0

for i in range(9):
    row = list(map(int, data[index:index + 9]))
    arr.append(row)
    index += 9

# 최대값과 위치 초기화
max_value = arr[0][0]
max_i = 0
max_j = 0

# 배열 순회하며 최대값과 위치 찾기
for i in range(9):
    for j in range(9):
        if arr[i][j] > max_value:
            max_value = arr[i][j]
            max_i = i
            max_j = j

# 최대값 출력
print(max_value)
# 최대값의 위치 출력 (1-indexed)
print(max_i + 1, max_j + 1)