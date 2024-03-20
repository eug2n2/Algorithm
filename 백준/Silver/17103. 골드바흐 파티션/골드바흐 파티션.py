#17103 골든바흐
a = [False,False] + [True]*(1000001)

for i in range(2,int(1000001 ** 0.5)+1 ):
    if a[i]:
        for j in range(i*i,1000001, i):
            a[j] = False

t =int(input()) # 테스트 케이스 
for i in range(t):
    n= int(input())
    count =0
    for i in range(2,n//2+1):
        if a[i] and a[n-i]:
            count+=1
    print(count)
    