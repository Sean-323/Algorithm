import sys
a = int(sys.stdin.readline())
num = (a * 2)

for i in range(1, num):
    if i <= a:
        print('*' * i + '  ' * (a - i) + '*' * i)

    elif i > a:
        print('*' * (num - i) + '  ' * (i - a) + '*' * (num - i))