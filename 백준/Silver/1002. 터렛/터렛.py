T=int(input()) # tc 수
for i in range(T):
    x1,y1,r1,x2,y2,r2=map(int,input().split())
    if (x1,y1) == (x2,y2) and r1 !=0 and r2 !=0:
        if r1 == r2:
            print(-1) 
            continue
        else:
            print(0)
            continue
    elif (x1,y1) == (x2,y2) and r1 == 0 and r2 == 0:
        print(1)
        continue
    elif (x1,y1) == (x2,y2):
        print(0)
        
## 원이 만나는가??? 
    d=((x1-x2)**2+(y1-y2)**2)**0.5 # 거리
    if d > r1 + r2: # 두 원이 멀리 떨어져 있음
        print(0)
    elif d < abs(r1 - r2): # 한 원이 다른 원 안에 있음
        print(0)
    elif d == r1 + r2: # 외접
        print(1)
    elif d == abs(r1 - r2): # 내접
        print(1)
    else: # 두 원이 교차함
        print(2)