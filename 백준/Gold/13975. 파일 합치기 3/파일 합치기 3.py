import heapq
import sys as s

def merge_file(file_sizes):
    heapq.heapify(file_sizes)
    total = 0

    while len(file_sizes) > 1:
        first = heapq.heappop(file_sizes)
        second = heapq.heappop(file_sizes)
        cost = first + second
        total += cost
        heapq.heappush(file_sizes, cost)

    return total

n = int(s.stdin.readline())

results = []
for _ in range(n):
   m = int(s.stdin.readline().strip())
   files = list(map(int, s.stdin.readline().strip().split()))
   results.append(merge_file(files))

print('\n'.join(map(str, results)))