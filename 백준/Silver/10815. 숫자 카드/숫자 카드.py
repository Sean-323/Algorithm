n = int(input())
arr = list(map(int, input().split()))
m = int(input())
cards = list(map(int, input().split()))

arr_set = set(arr)
result = []

for card in cards:
    if card in arr_set:
        result.append(1)
    else:
        result.append(0)

print(' '.join(map(str, result)))