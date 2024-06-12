import sys as s

def smallest_word(word):
    n = len(word)
    smallest = None

    for i in range(1, n - 1):
        for j in range(i + 1, n):
            part1 = word[:i][::-1]
            part2 = word[i:j][::-1]
            part3 = word[j:][::-1]

            combined = part1 + part2 + part3

            if smallest is None or combined < smallest:
                smallest = combined

    return smallest

word = s.stdin.readline().strip()
result = smallest_word(word)
print(result)