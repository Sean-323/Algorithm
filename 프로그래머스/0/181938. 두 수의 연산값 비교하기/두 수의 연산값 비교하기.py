def solution(a, b):
    c = 2 * a * b
    a, b = str(a), str(b)
    return max(int(a + b), c)