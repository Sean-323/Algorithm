import sys
a = sys.stdin.readline()

for i in range(int(a)):
    b, c = map(str, sys.stdin.readline().split())
    b = int(b)
    for i in c:
        print(i * b, end="")
    print()