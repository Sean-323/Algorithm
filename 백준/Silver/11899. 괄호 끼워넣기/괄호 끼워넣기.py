def brackets(barckets):
    count = 0
    result = 0

    for bracket in barckets:
        if bracket == '(':
            count += 1
        else:
            if count > 0:
                count -= 1
            else:
                result += 1
    result += count
    return result

brackets_input = input().strip()
print(brackets(brackets_input))