#14502
n=int(input())
graph=[]
for i in range(n):
    graph.append(list(input().split()))
answer=0
for i in range(n):
    for j in range(n):
        if graph[i][j]=="S":
            answer+=1    
temp=[[0]*n for _ in range(n)]
dx =[-1,0,1,0]
dy=[0,1,0,-1]
result = 0
def go(x,y,i):
    for i in range(i,i+1):
        nx=x+dx[i]
        ny=y+dy[i]
        if nx>=0 and nx<n and ny>=0 and ny<n:
            if temp[nx][ny]=="X":  
                go(nx,ny,i)
            elif temp[nx][ny]=="S":
                temp[nx][ny]="C"
                go(nx,ny,i)
def see(x,y):
    for i in range(4):
        nx=x+dx[i]
        ny=y+dy[i]
        if nx>=0 and nx<n and ny>=0 and ny<n:
            if temp[nx][ny]=="X":  
                go(nx,ny,i)
            elif temp[nx][ny]=="S":
                temp[nx][ny]="C"
                go(nx,ny,i)
def get_score():
    score =0
    for i in range(n):
        for j in range(n):
            if temp[i][j]=="S": #감시 피함 
                score+=1
    return score

def dfs(count):
    global result
    if count ==3:
        for i in range(n):
            for j in range(n):
                temp[i][j] = graph[i][j]
        for i in range(n):
            for j in range(n):
                if temp[i][j]=="T":
                    see(i,j)
        result = max(result,get_score())
        return
    for i in range(n):
        for j in range(n):
            if graph[i][j]=="X":
                graph[i][j]="O"
                count+=1
                dfs(count)
                graph[i][j]="X"
                count-=1
            
dfs(0)
if result == answer:
    print("YES")
else:
    print("NO")