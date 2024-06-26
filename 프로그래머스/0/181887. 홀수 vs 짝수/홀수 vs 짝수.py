def solution(num_list):
    odd_sum = 0  
    even_sum = 0  
    
    for index, num in enumerate(num_list):
        if index % 2 == 0:  
            odd_sum += num
        else:  
            even_sum += num

    return max(odd_sum, even_sum)