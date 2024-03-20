n=int(input())
a =list(map(int,input().split()))
a.sort()
def bla(x):
    answer=0
    for i in range(n):
        answer+= abs(a[x]-a[i])
    return answer
if n%2==1: 
    print(a[n//2])
elif bla(n//2)<bla(n//2-1):
    print(a[n//2])
else: 
    print(a[n//2-1])