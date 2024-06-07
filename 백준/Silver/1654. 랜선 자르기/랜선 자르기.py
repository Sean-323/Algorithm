n, k = map(int, input().split())
lines = [int(input()) for _ in range(n)]
ans = 1 # 정답은 항상 1 이상이에요.
left = 1
right = 2 ** 31 - 1 # 전선 최대 길이
while left <= right:
    mid = (left + right) // 2
    cnt = 0
    for line in lines:
        cnt += line // mid # 전선 길이로 나눈 몫이 만들 수 있는 전선의 개수에요.
    if cnt >= k: # k개 이상의 전선을 만들 수 있으면 정답을 갱신!
        ans = mid
        left = mid + 1
    else:
        right = mid - 1
print(ans)