def solution(str_list, ex):
    result = []
    for s in str_list:
        if ex not in s:
            result.append(s)
    return ''.join(result)