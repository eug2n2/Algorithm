import sys
T=int(sys.stdin.readline()) # tc 수
for i in range(T):
    x1,y1,r1,x2,y2,r2=map(int,sys.stdin.readline().split())

    ## 원이 만나는가??? 
    d=((x1-x2)**2+(y1-y2)**2)**0.5 # 거리

    if d==0 and r1==r2: # 동심원 (같은 원의 중심, 같은 반지름)
        print(-1)
    elif d > r1 + r2 or d < abs(r1 - r2): # 두 원이 만나지 않거나, 한 원이 다른 원 안에 있음
        print(0)
    elif d == r1 + r2 or d == abs(r1 - r2): # 외접/ 내접
        print(1)
    else: # 두 원이 교차함
        print(2)