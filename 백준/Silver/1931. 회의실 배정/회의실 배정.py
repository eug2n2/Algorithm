import sys
input= sys.stdin.readline
a=[]
n=int(input())
for i in range(n):
    x,y=map(int,input().split())
    a.append([x,y])
a= sorted(a,key=lambda x:(x[1],x[0]))
dp=1
end=a[0][1]
for i in range(1,n):
    if a[i][0]>=end:
        end =a[i][1]
        dp+=1
print(dp)
         
        