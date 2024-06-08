def solution(my_string, index_list):
    result = ''.join(my_string[i] for i in index_list)
    return result