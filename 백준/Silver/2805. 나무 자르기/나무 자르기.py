import sys

def main():
    input = sys.stdin.read
    data = input().split()
    
    N = int(data[0])
    M = int(data[1])
    arr = list(map(int, data[2:2+N]))

    left, right = 0, max(arr)
    result = 0

    while left <= right:
        mid = (left + right) // 2
        total = sum(h - mid for h in arr if h > mid)

        if total >= M:
            result = mid
            left = mid + 1
        else:
            right = mid - 1

    print(result)

if __name__ == "__main__":
    main()