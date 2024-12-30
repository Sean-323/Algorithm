N = input()

numbers = [int(char) for char in N]

result = 0
for i in numbers:
    result += i

print(result)