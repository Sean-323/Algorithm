while True:
    n = int(input())

    if n == 0:
        break

    words = []

    for _ in range(n):
        word = input()
        words.append(word)

    words.sort(key=str.lower)
    print(words[0])