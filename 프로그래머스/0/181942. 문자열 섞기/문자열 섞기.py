def solution(str1, str2):
    answer = ''
    for i in range(len(str1)):
        answer += (str1[i][0] + str2[i][0]) 
    return answer