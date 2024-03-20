import sys 
a = [False,False] + [True]*(999999)

for i in range(2,int(1000001 ** 0.5)+1 ):
    if a[i]:
        for j in range(i*i,1000001, i):
            a[j] = False

while True:
    n= int(sys.stdin.readline())
    if n==0:
        break
    else:
        for i in range(3,n//2+1,2):
            if a[i] and a[n-i]:
                print(n,"=",i,"+",n-i)
                break
