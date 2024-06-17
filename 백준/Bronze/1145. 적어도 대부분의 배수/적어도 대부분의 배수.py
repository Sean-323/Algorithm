import sys as s
import math as m
from itertools import combinations


def lcm(a, b):
    return abs(a * b) // m.gcd(a, b)  # 최소공배수 구하기


def lcm_v3(a, b, c):
    return lcm(lcm(a, b), c)


def solution(num):
    result = []

    for comb in combinations(num, 3):
        result.append(lcm_v3(*comb))
    return min(result)


numbers = list(map(int, s.stdin.readline().split()))
print(solution(numbers))