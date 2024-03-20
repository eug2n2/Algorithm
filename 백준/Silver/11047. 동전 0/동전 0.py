n,k =map(int,input().split())
a=[]
for i in range(n):
    a.append(int(input()))
count =0

a.reverse()
for i in range(n):
    if a[i]<=k:
        count+=k//a[i]
        k=k%a[i]   
    if k==0:
        break
print(count)