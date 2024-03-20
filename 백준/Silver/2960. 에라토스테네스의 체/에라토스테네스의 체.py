# 2960
def is_prime(x):
    for i in range(2, x):
        # x가 해당 수로 나누어떨어진다면
        if x % i == 0:
            return False # 소수가 아님
            break
    return True
n,k = map(int,input().split())
count =0
nlist =[]
for i in range(1,n+1):
    nlist.append(i)
for i in range(2,n+1):
    if is_prime(i):
        for p in range(1,n//i+1):
            if p*i in nlist:
                nlist.remove(p*i)
                
                count +=1
            if count==k:
                print(p*i)
                break
        