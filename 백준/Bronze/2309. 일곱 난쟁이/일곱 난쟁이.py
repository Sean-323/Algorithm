import itertools

arr = [int(input()) for _ in range(9)]
result = next(sorted(c) for c in itertools.combinations(arr, 7) if sum(c) == 100)

print("\n".join(map(str,result)))