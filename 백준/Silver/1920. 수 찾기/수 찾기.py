n = input()
sources = list(map(int, input().split()))
visited = {}
for source in sources:
    visited[source] = 1

m = input()
targets = list(map(int, input().split()))
for target in targets:
    print(visited.get(target, 0))