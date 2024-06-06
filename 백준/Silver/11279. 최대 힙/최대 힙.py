from heapq import *
from sys import stdin

input = stdin.readline

N = int(input())
heap = []
for _ in range(N):
    a = int(input())
    if a:
        heappush(heap, -a) # - 값 삽입
    else:
        if heap:
            print(-heappop(heap)) # - 값을 삽입했으니, 추출할 때 - 다시 붙여주기
        else:
            print(0)