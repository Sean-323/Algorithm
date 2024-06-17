import sys as s
n = int(s.stdin.readline().strip())


def octopus(n):
    result = []

    for i in range(1, n + 1):
        if i % 2 == 0:
            result.append(2)
        else:
            result.append(1)

    if n % 2 == 1:
        result[-1] = 3

    return ' '.join(map(str, result))

print(octopus(n))