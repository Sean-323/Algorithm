import sys

# 방의 크기를 입력 받음
n = int(sys.stdin.readline().strip())

# n x n 배열 초기화 및 데이터 입력
matrix = []
for _ in range(n):
    matrix.append(list(sys.stdin.readline().strip()))

def findrow(matrix):
    rowcount = 0
    for row in matrix:
        count = 0
        for i in row:
            if i == '.':
                count += 1
            else:
                if count >= 2:
                    rowcount += 1
                count = 0
        if count >= 2:
            rowcount += 1
    return rowcount

def findcol(matrix):
    colcount = 0
    n = len(matrix)
    for i in range(n):
        count = 0
        for j in range(n):
            if matrix[j][i] == '.':
                count += 1
            else:
                if count >= 2:
                    colcount += 1
                count = 0
        if count >= 2:
            colcount += 1
    return colcount

row = findrow(matrix)
col = findcol(matrix)

print(row, col)