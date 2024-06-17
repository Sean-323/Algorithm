from itertools import permutations


def solution(expression):
    # 연산자와 숫자를 나누어서 저장
    answer = 0
    cal = ['+', '-', '*']
    nums = []
    cals = []
    num = ''
    for char in expression:
        if char in cal:
            cals.append(char)
            nums.append(int(num))
            num = ''
        else:
            num += char
    nums.append(int(num))

    # 연산자 우선순위에 따라 계산
    orders = list(permutations(cal, 3))
    for order in orders:
        answer = max(answer, abs(calculation(order, nums, cals)))
    return answer


def calculation(order, nums, cals):
    # 각 연산자들을 우선순위에 맞게 계산해줄게요.
    for i in range(3):
        stack1 = [nums[0]]
        stack2 = []
        for j in range(len(cals)):
            if cals[j] != order[i]:
                stack1.append(nums[j + 1])
                stack2.append(cals[j])
            else:
                if order[i] == '+':
                    stack1.append(stack1.pop() + nums[j + 1])
                elif order[i] == '-':
                    stack1.append(stack1.pop() - nums[j + 1])
                else:
                    stack1.append(stack1.pop() * nums[j + 1])
        nums = stack1
        cals = stack2
    return stack1[0]