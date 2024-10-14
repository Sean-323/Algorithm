n = int(input())
members = [list(map(int, input().split())) for _ in range(n)]

for i in range(n):
    rank = 1
    for j in range(n):
        if members[i][0] < members[j][0] and members[i][1] < members[j][1]:
            rank += 1
    print(rank, end=' ')
