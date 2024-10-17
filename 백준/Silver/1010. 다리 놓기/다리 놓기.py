# 팩토리얼을 계산하는 함수
def factorial(num):
    result = 1
    for i in range(2, num + 1):
        result *= i
    return result

# 조합을 계산하는 함수
def combination(m, n):
    return factorial(m) // (factorial(n) * factorial(m - n))

# 입력 처리
t = int(input())  # 테스트 케이스 수
result = []

for _ in range(t):
    n, m = map(int, input().split())
    result.append(combination(m, n))  # 조합 계산 결과를 저장

# 결과 출력
for i in result:
    print(i)
