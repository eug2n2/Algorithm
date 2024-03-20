
import heapq
import sys
input= sys.stdin.readline
heap=[]
n=int(input())
for i in range(n):
    x=int(input())
    if x==0 and len(heap)==0:
        print(0)
    elif x==0:
        result = heapq.heappop(heap)
        print(result)
    else:
        heapq.heappush(heap,x)
       
        