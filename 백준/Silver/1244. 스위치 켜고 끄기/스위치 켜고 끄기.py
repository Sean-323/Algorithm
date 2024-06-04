def change_mode(switches, idx):
    switches[idx] ^= 1

n = int(input().strip())
switches = list(map(int, input().strip().split()))
students = int(input().strip())

for _ in range(students):
    gender, num = map(int, input().strip().split())
    if gender == 1:
        for i in range(num - 1, n, num):
            change_mode(switches, i)
    else:
        num -= 1
        left = right = num
        while left >= 0 and right < n and switches[left] == switches[right]:
            change_mode(switches, left)
            if left != right:
                change_mode(switches, right)
            left -= 1
            right += 1

for i in range(0, n, 20):
    print(*switches[i:i+20])