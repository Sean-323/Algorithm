def solution(num_list):
    last = num_list[-1]
    second_last = num_list[-2]

    if second_last < last:
        c = last - second_last
    else:
        c = last * 2

    num_list.append(c)
    return num_list