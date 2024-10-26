import sys
input = sys.stdin.read

def dfs(node, visited, permutation):
    while not visited[node]:
        visited[node] = True
        node = permutation[node]

def count_cycles(n, permutation):
    visited = [False] * (n + 1)
    cycles = 0

    for i in range(1, n + 1):
        if not visited[i]:
            dfs(i, visited, permutation)
            cycles += 1
    
    return cycles

data = input().split()
t = int(data[0])
idx = 1
results = []

for _ in range(t):
    n = int(data[idx])
    permutation = [0] + list(map(int, data[idx + 1: idx + 1 + n]))
    idx += n + 1
    results.append(count_cycles(n, permutation))

print("\n".join(map(str, results)))