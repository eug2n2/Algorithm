#소수찾기 1978
def is_prime(x):
    # 2부터 (x - 1)까지의 모든 수를 확인하며
    for i in range(2, x):
        # x가 해당 수로 나누어떨어진다면
        if x % i == 0:
            return False # 소수가 아님
    return True # 소수

n= int(input())
nlist = list(map(int,input().split()))
count =0
for nlist in nlist:
    if nlist!=1 and is_prime(nlist):
        count +=1
print(count)
