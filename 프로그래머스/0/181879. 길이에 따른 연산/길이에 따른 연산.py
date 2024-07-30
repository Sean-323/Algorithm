def solution(num_list):
    result = 0

    if len(num_list) >= 11 :
        for i in num_list:
            result += i
    else:
        result += 1
        for i in num_list:
            result *= i

    return result