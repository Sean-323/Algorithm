def solution(numLog):
    operations = ""
    for i in range(1, len(numLog)):
        diff = numLog[i] - numLog[i - 1]
        if diff == 1:
            operations += "w"
        elif diff == -1:
            operations += "s"
        elif diff == 10:
            operations += "d"
        elif diff == -10:
            operations += "a"
    return operations
