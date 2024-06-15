import sys as s

a = s.stdin.readline().rstrip()
b = s.stdin.readline().rstrip()
love = ''

for i in range(8):
    love += a[i]
    love += b[i]

while len(love) > 2:
    result = ''

    for i in range(len(love) - 1):
        temp = int(love[i]) + int(love[i+1])
        result += str(temp % 10)
    love = result

print(love)