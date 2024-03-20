import heapq
import sys
input= sys.stdin.readline
heap=[]
a=[]
n=int(input())
for i in range(n):
    x=int(input())
    if x==0 and len(heap)==0:
        print(0)
    elif x==0:
        result = heapq.heappop(heap)
        if result*(-1) in a:
            print(-1*result)
            a.remove(-1*result)
        else:
            print(result)
            a.remove(result)
    else:
        heapq.heappush(heap,abs(x))
        a.append(x)
       
        