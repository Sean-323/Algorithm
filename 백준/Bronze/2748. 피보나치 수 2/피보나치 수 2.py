def fibonaci(n):
    numbers = []

    for i in range(n + 1):
        if i < 2:
            numbers.append(i)
        else:
            numbers.append(numbers[i - 2] + numbers[i - 1])

    return numbers[-1]

n = int(input())

print(fibonaci(n))