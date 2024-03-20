#9095
t=int(input())
for i in range(t):
    N=int(input())
    dp =[0,1,2,4]
    for i in range(4,N+1):
        dp.append(dp[i-2]+dp[i-1]+dp[i-3])
    print(dp[N])