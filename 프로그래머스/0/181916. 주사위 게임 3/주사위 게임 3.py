from collections import Counter

def solution(a, b, c, d):
    counts = Counter([a, b, c, d])
    freq = counts.most_common()

    if freq[0][1] == 4:
        p = freq[0][0]
        return 1111 * p
    elif freq[0][1] == 3:
        p = freq[0][0]
        q = freq[1][0]
        return (10 * p + q) ** 2
    elif freq[0][1] == 2 and freq[1][1] == 2:
        p = freq[0][0]
        q = freq[1][0]
        return (p + q) * abs(p - q)
    elif freq[0][1] == 2 and freq[1][1] == 1 and freq[2][1] == 1:
        p = freq[0][0]
        q = freq[1][0]
        r = freq[2][0]
        return q * r
    else:
        return min(a, b, c, d)