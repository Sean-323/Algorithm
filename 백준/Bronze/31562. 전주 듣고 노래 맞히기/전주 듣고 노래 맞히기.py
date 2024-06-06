import sys
input = sys.stdin.readline

N, M = map(int, input().strip().split())
song = {}

for _ in range(N):
    line = input().strip().split()
    name = line[1]
    music1 = ' '.join(line[2:5])  # 첫 세 개의 음을 문자열로 저장
    if music1 not in song:
        song[music1] = []
    song[music1].append(name)

results = []

for _ in range(M):
    music2 = ' '.join(input().strip().split())
    if music2 in song:
        if len(song[music2]) > 1:
            results.append("?")
        else:
            results.append(song[music2][0])
    else:
        results.append("!")

print("\n".join(results))