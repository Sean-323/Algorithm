n = int(input())
words = {input() for _ in range(n)}
words = list(words)

words.sort(key=lambda x : (len(x), x))

for word in words:
    print(word)