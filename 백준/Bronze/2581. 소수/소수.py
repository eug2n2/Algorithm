# 2581 소수
def is_prime(x):
    for i in range(2, x):
        # x가 해당 수로 나누어떨어진다면
        if x % i == 0:
            return False # 소수가 아님
    return True # 소수

n= int(input())
m= int(input())
total = 0
answer = 1e9
for i in range(n,m+1):
    if i!=1 and is_prime(i):
        total+=i
        answer =min(i,answer)

if total ==0:
    print(-1)
else:
    print(total)
    print(answer)