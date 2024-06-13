import sys as s

def palindrome(s):
    from collections import Counter

    count = Counter(s)
    mid = ""
    half = []

    for char in sorted(count.keys()):
        if count[char] % 2 != 0:
            if mid == "":
                mid = char
            else:
                return "I'm Sorry Hansoo"
        half.append(char * (count[char] // 2))

    half_str = ''.join(half)

    return half_str + mid + half_str[::-1]

a = s.stdin.readline().strip()
print(palindrome(a))