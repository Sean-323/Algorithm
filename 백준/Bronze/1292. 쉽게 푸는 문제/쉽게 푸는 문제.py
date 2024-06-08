sequence = []
for i in range(1, 51):
    sequence.extend([i] * i)

A, B = map(int, input().split())
result = sum(sequence[A-1:B])
print(result)