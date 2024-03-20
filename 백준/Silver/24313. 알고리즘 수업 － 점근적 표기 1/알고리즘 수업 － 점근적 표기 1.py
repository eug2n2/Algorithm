#24313 
a,b = map(int,input().split())
g = int(input())
n= int(input())
if a==g:
    if b>=0:
        print(0)
    else:
        print(1)
elif g-a>0 and b/(g-a)<=n:
    print(1)
else:
    print(0)
