import sys
input =sys.stdin.readline
n,m =map(int,input().split())
graph=[]
for i in range(n):
    graph.append(list(map(int,input().split())))
temp = [[0] * m for _ in range(n)]
dx=[1,0,-1,0]
dy=[0,1,0,-1]
def virus(x,y):
    for i in range(4):
        nx = x+ dx[i]
        ny = y+ dy[i]
        if nx >= 0 and nx < n and ny >= 0 and ny < m:
            if temp[nx][ny]==0:
                temp[nx][ny]=2     
                virus(nx,ny)
def get_score():
    count=0
    for i in range(n):
        for j in range(m):
            if temp[i][j]==0:
                count+=1    
    return count
result =0

def atry(tim):
    global result
    if tim ==3:
        for i in range(n):
            for j in range(m):
                temp[i][j]=graph[i][j]
        for i in range(n):
            for j in range(m):
                if temp[i][j]==2:
                    virus(i,j)
        result = max(get_score(), result)
        return
    for i in range(n):
        for j in range(m):
            if graph[i][j]==0:
                graph[i][j]=1
                tim+=1
                atry(tim)
                graph[i][j]=0
                tim-=1

atry(0)
print(result)