import sys as s

n = int(s.stdin.readline().strip())
k = int(s.stdin.readline().strip())
sensors = list(map(int, s.stdin.readline().strip().split()))

sensors.sort()

distances = sorted(sensors[i + 1] - sensors[i] for i in range(n - 1))
distances.sort(reverse=True)
result = sum(distances[k - 1:])
print(result)