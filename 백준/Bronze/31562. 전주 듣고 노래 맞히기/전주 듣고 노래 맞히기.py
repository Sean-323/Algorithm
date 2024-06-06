import sys

input = sys.stdin.readline

N, M = map(int, input().strip().split())
song = {}

for _ in range(N):
    line = input().strip().split()
    T, name, a1, a2, a3, a4, a5, a6, a7 = line
    music1 = [a1, a2, a3]
    song[name] = music1

results = []

for _ in range(M):
    music2 = input().strip().split()
    count = 0
    title = ""

    for s in song:
        if music2 == song[s]:
            count += 1
            title = s

    if count >= 2:
        results.append("?")
    elif count == 1:
        results.append(title)
    else:
        results.append("!")

for result in results:
    print(result)