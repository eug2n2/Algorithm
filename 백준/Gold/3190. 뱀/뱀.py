#A11 뱀 
N =int(input())
K=int(input())

second=[] # 초
move=[]
maap= [[0]*N for _ in range(N)]

for _ in range(K):
    n,m= map(int,input().split())
    maap [n-1][m-1]= 2 #사과

L =int(input())
move = [0]*(N*N)# 방향
for _ in range(L):
    t, d= input().split()
    t=int(t)
    second.append (t)
    move[t]=d 
snake =[(0,0)] #뱀길이
time = 0 # 누적이동시간
D=0
a=0
b=0
while  True:
    if time in second:
        if move[time]== "L": #방향회전 
            D -=1
            if D == -1:
                D=3
        elif move[time]=="D":#오른쪽으로 90도 회전
            D +=1
            if D==4:
                D=0
                       
    if D ==0: #동쪽 
        if b== N-1:
            time +=1
            print(time)
            break
        else:
            if (a,b+1) in snake: #자기자신을 만나 게임종료
                time +=1
                print(time)
                break
            elif maap[a][b+1]==0: # 사과없이 이동
                time +=1
                b+=1 
                snake.append((a,b))
                del snake[0]
            elif maap[a][b+1]==2:
                maap[a][b+1]=0
                time+=1  
                b+=1
                snake.append((a,b))

    if D == 1: #남쪽 
        if a==N-1:
            time +=1
            print(time)
            break
        else:
            if (a+1,b) in snake:
                time +=1
                print(time)
                break
            elif maap[a+1][b]==0: # 사과없이 이동
                time +=1
                a+=1
                snake.append((a,b))
                del snake[0]
            elif maap[a+1][b]==2:
                maap[a+1][b]=0
                time+=1  
                a+=1
                snake.append((a,b))
       

    if D == 2: #서쪽   
        if b==0:
            time +=1
            print(time)
            break
        else:   
            if (a,b-1) in snake:
                time +=1
                print(time)
                break
            elif maap[a][b-1]==0: # 사과없이 이동
                time +=1
                b-=1
                snake.append((a,b))
                del snake[0]
            elif maap[a][b-1]==2:
                maap[a][b-1]=0
                b-=1
                snake.append((a,b))
                time+=1  
                
    if D ==3: #북쪽    
        if a==0:
            time +=1
            print(time)
            break
        else:
            if (a-1,b) in snake:
                time +=1
                print(time)
                break
            elif maap[a-1][b]==0: # 사과없이 이동
                time +=1
                a-=1
                snake.append((a,b))
                del snake[0]
            elif maap[a-1][b]==2:
                maap[a-1][b]=0
                time+=1 
                a-=1
                snake.append((a,b))
                
           