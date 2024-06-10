def solution(code):
    mode = 0  
    ret = ""  
    
    for idx in range(len(code)):
        if code[idx] == '1':
            # mode를 바꿉니다.
            mode = 1 - mode
        else:
            if mode == 0:
                if idx % 2 == 0:
                    ret += code[idx]
            else:
                if idx % 2 != 0:
                    ret += code[idx]
    
    if ret == "":
        return "EMPTY"
    else:
        return ret