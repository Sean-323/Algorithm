def main():
    N = int(input())

    for i in range(N):
        for j in range(N):
            if (i == 0) or (i == N - 1):
                print("*", end="")
            elif (j == 0) or (j == N - 1):
                print("*", end="")
            elif (i == j) or (i == N - 1 - j):
                print("*", end="")
            else:
                print(" ", end="")
        print()

if __name__ == "__main__":
    main()