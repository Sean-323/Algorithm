# 입력 받기
start_time = input().strip()
end_time = input().strip()

# 시각을 시, 분, 초로 분리
start_h, start_m, start_s = map(int, start_time.split(':'))
end_h, end_m, end_s = map(int, end_time.split(':'))

# 각 시각을 초 단위로 변환
start_total_seconds = start_h * 3600 + start_m * 60 + start_s
end_total_seconds = end_h * 3600 + end_m * 60 + end_s

# 두 시각의 차이 계산
if end_total_seconds < start_total_seconds:
    end_total_seconds += 24 * 3600  # 다음 날의 시간을 더해줌

time_difference = end_total_seconds - start_total_seconds

# 결과 출력
print(time_difference)