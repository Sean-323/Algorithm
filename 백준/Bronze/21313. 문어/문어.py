import sys
n = int(sys.stdin.readline().strip())

result = []

# 홀수일 경우 마지막 문어가 첫 번째 문어와 손을 잡지 않도록 3을 추가
if n % 2 == 1:
    for i in range(1, n + 1):
        if i % 2 == 0:
            result.append(2)
        else:
            result.append(1)
    result[-1] = 3  # 마지막 문어는 3번 손으로 변경
else:
    for i in range(1, n + 1):
        if i % 2 == 0:
            result.append(2)
        else:
            result.append(1)

print(' '.join(map(str, result)))