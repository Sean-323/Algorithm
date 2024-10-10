n = int(input())

members = []
for _ in range(n):
    name, dd, mm, year = input().split()
    members.append((name, int(dd), int(mm), int(year)))

members.sort(key=lambda x : (x[3], x[2], x[1]), reverse=True)
print(members[0][0])
print(members[-1][0])