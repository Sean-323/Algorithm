n = int(input())
str_list = []

for i in range(n):
    str_list.append(input())

n = int(input())
str2_list = []

for i in range(n):
    str2_list.append(input())

if '?' in str_list:
    idx = str_list.index('?')

    if idx == 0: # ?가 맨 처음일 경우
        first_char = ""
    else:
        first_char = str_list[idx - 1][-1] # 앞단어 마지막 글자

    if idx == len(str_list) - 1:
        last_char = ""
    else:
        last_char = str_list[idx + 1][0] # 뒷단어 첫글자

    for word in str2_list:
        if word not in str_list:
            if (first_char == "" or first_char == word[0]) and (last_char == "" or last_char == word[-1]):
                print(word)
                break