def transform(arr):
    result = []
    for num in arr:
        if num >= 50 and num % 2 == 0:
            result.append(num // 2)
        elif num < 50 and num % 2 == 1:
            result.append(num * 2 + 1)
        else:
            result.append(num)
            
    return result

def solution(arr):
    count = 0
    while True:
        new_arr = transform(arr)
        if new_arr == arr:
            return count
        arr = new_arr
        count += 1