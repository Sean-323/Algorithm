import sys
input = sys.stdin.readline

k = int(input())
signs = input().split()

min_result = ""
max_result = ""
visited = [False] * 10  

def check(a, b, sign):
    if sign == '<':
        return a < b
    elif sign == '>':
        return a > b

def dfs(index, current):
    global min_result, max_result

    if index == k + 1:
        if not min_result:
            min_result = current  
        else:
            max_result = current  
        return

    for i in range(10):
        if not visited[i]:
            if index == 0 or check(int(current[-1]), i, signs[index - 1]):
                visited[i] = True
                dfs(index + 1, current + str(i))
                visited[i] = False 

for i in range(10):
    visited[i] = True
    dfs(1, str(i))
    visited[i] = False

print(max_result)
print(min_result)