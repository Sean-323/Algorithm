import itertools

arr = [int(input()) for _ in range(9)]
result = next(sorted(comb) for comb in itertools.combinations(arr, 7) if sum(comb) == 100)

for num in result:
    print(num)