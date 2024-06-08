N = int(input())
dasom = int(input())
others = [int(input())for i in range(N - 1)]
votes = 0

while others and dasom <= max(others):
    max_votes = max(others)
    max_idx = others.index(max_votes)
    others[max_idx] -= 1
    dasom += 1
    votes += 1

print(votes)