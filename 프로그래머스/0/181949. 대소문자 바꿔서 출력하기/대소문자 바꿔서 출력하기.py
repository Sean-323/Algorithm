str = input()
result = []
for i in str:
    if i.isupper():
        result.append(i.lower())
    else:
        result.append(i.upper())
        
for i in result:
    print(i, end='')
    
        