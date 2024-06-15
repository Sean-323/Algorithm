N, M = map(int, input().split())
dp = [0] * (M + 1) # dp[i]는 i만큼의 무게를 가지는 가방에 담을 수 있는 최대 가치를 의미해요.
for _ in range(N):
    m, v = map(int, input().split())
    for j in range(M, m - 1, -1): # 무게가 m인 물건을 가방에 담는 상황입니다. 역순으로 하지 않으면 중복으로 담을 수 있으니 주의해주세요!
        dp[j] = max(dp[j], dp[j - m] + v)
print(dp[-1])