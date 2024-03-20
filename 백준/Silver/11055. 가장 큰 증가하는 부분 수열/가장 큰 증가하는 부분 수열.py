n=int(input())
a=list(map(int,input().split()))
dp=[1]*(n)
dp[0]=a[0]

for i in range(1,n):
    dp[i] =a[i]
    for k in range(i):
        if a[k]<a[i]:
            dp[i]=max(dp[i],dp[k]+a[i])
    
print(max(dp))

