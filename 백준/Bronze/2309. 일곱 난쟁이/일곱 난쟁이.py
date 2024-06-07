import itertools

arr = []
for i in range(9):
    arr.append(int(input()))

combinations = list(itertools.combinations(arr, 7))

for comb in combinations:
    if sum(comb) == 100:
        result = sorted(comb)
        break

for i in result:
    print(i)

