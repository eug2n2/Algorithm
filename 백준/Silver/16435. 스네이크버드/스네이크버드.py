#16435
n,length = map(int,input().split())
h= list(map(int,input().split()))
h.sort()
yum=length
for i in range(n):
    if h[i]<=yum:
        yum+=1     
print(yum)