# 입력받기
import sys
input = sys.stdin.read
data = input().split()

# 첫 번째 줄은 테스트 케이스 개수
T = int(data[0])

# 결과 저장 리스트
results = []

# 각 테스트 케이스에 대해 검사
for i in range(1, T + 1):
    password = data[i]
    length = len(password)
    if 6 <= length <= 9:
        results.append("yes")
    else:
        results.append("no")

# 결과 출력
for result in results:
    print(result)