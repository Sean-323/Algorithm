def solution(number):
    digit_sum = sum(int(digit) for digit in number)
    return digit_sum % 9