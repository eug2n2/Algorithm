N = int(input())
dp = [2000,2000,2000,1,2000,1]

for i in range(6,N+1):
    dp.append(2000)
    if dp[i-3]!= 2000:
        dp[i] = dp[i-3]+1
    if dp[i-5]!=2000:    
        dp[i] = min(dp[i-5]+1, dp[i])
if dp[N]==2000:
    print(-1)
else:
    print(dp[N])