def check_max_length(grid, n):
    #현재 격자 상태에서 최대 연속 길이를 계산
    max_length = 0

    # 가로 방향 탐색
    for i in range(n):
        count = 1
        for j in range(1, n):
            if grid[i][j] == grid[i][j - 1]:
                count += 1
            else:
                max_length = max(max_length, count)
                count = 1
        max_length = max(max_length, count)  # 마지막 연속 확인

    # 세로 방향 탐색
    for j in range(n):
        count = 1
        for i in range(1, n):
            if grid[i][j] == grid[i - 1][j]:
                count += 1
            else:
                max_length = max(max_length, count)
                count = 1
        max_length = max(max_length, count)  # 마지막 연속 확인

    return max_length


# 입력 처리
n = int(input())
grid = [list(input().strip()) for _ in range(n)]

max_candy = 0

# 격자 탐색 (모든 칸에서 인접한 칸과 교환 시도)
for i in range(n):
    for j in range(n):
        # 오른쪽과 교환
        if j + 1 < n:
            grid[i][j], grid[i][j + 1] = grid[i][j + 1], grid[i][j]  # 교환
            max_candy = max(max_candy, check_max_length(grid, n))
            grid[i][j], grid[i][j + 1] = grid[i][j + 1], grid[i][j]  # 복구

        # 아래쪽과 교환
        if i + 1 < n:
            grid[i][j], grid[i + 1][j] = grid[i + 1][j], grid[i][j]  # 교환
            max_candy = max(max_candy, check_max_length(grid, n))
            grid[i][j], grid[i + 1][j] = grid[i + 1][j], grid[i][j]  # 복구

# 결과 출력
print(max_candy)