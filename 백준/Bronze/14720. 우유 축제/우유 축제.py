import sys as s

n = int(s.stdin.readline().strip())
shop = list(map(int, s.stdin.readline().strip().split()))
milk = [0, 1, 2]
count, current_milk = 0, 0

for i in range(n):
    if shop[i] == milk[current_milk]:
        count += 1
        current_milk  = (current_milk + 1) % 3
print(count)