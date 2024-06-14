import sys as s

n = 1000 - int(s.stdin.readline().strip()) 
money_list = [500, 100, 50, 10, 5, 1] 
count = 0  

for i in money_list:
    if n >= i: 
        count += n // i 
        n %= i 

print(count)  