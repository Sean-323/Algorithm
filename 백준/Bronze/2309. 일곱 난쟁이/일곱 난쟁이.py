import itertools

arr = [int(input()) for _ in range(9)]
comb = list(itertools.combinations(arr, 7))

for c in comb:
    if sum(c) == 100:
        result = sorted(c)
        break

print("\n".join(map(str, result)))