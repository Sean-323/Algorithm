def min_rotation(num):
    #숫자의 최소 회전수 계산
    rotations = [int(num[i:] + num[:i]) for i in range(4)]
    return min(rotations)

# 입력 처리
cards = input().replace(" ", "")  # 입력된 숫자를 문자열로 변환
target = min_rotation(cards)  # 입력 숫자의 최소 회전수

# 전체 최소 회전수 목록 생성
rotations = set()
for n in range(1111, 10000):
    if '0' not in str(n):  # 조건: 숫자에 0이 없어야 함
        rotations.add(min_rotation(str(n)))

# 정렬 후 위치 찾기
sorted_rots = sorted(rotations)
print(sorted_rots.index(target) + 1)