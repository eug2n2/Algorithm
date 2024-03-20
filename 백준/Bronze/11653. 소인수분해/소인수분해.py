#11653 소인수분해

def is_prime(x):
    for i in range(2, x):
        # x가 해당 수로 나누어떨어진다면
        if x % i == 0:
            return False # 소수가 아님
    return True # 소수

def divide(a):
    for i in range(2,n+1):
        if is_prime(i) and a%i==0:
            print(i)
            break
    return a//i

n =int(input())
a=n
if n==1:
    print()
elif is_prime(n):
    print(n)
else:
    while not is_prime(a):
        a= divide(a)
    print(a)