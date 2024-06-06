import sys as s
input = s.stdin.readline

def char_to_num(char):
    return ord(char) - 96

r = 31
M = 1234567891

n = int(input().strip())
s = input().strip()

hash_value = 0
for i in range(n):
    hash_value += char_to_num(s[i]) * (r ** i)
    hash_value %= M

print(hash_value)