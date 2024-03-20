n=int(input())
a=list(map(int,input().split()))
dp=[1]*(n)
for i in range(1,n):
    for k in range(i):
        if a[k]<a[i]:
            dp[i]=max(dp[i],dp[k]+1)

        
print(max(dp))

