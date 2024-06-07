n = int(input())
arr = list(map(int, input().split()))

arr.sort()
min_time = 0
total_time = 0

for i in range(n):
    total_time += arr[i]
    min_time += total_time
        
print(min_time)