mushrooms = [int(input()) for _ in range(10)]

total = 0
closest = 0

for mushroom in mushrooms:
    total += mushroom
    if abs(100 - total) <= abs(100 - closest):
        closest = total

print(closest)