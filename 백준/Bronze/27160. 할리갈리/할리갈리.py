import sys
n = int(sys.stdin.readline().strip())

cards = {
    'STRAWBERRY': 0,
    'BANANA': 0,
    'LIME': 0,
    'PLUM': 0
}

for i in range(n):
    a, b = map(str, sys.stdin.readline().strip().split())
    if a in cards:
        cards[a] += int(b)

if 5 in cards.values():
    print('YES')
else:
    print('NO')