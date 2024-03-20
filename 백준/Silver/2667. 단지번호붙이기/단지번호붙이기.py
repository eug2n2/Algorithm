n=int(input())
graph =[]
for i in range(n):
    graph.append(list(map(int,input())))
answer =0 #단지
result=[0]*1000
def dfs(x,y,k):
    if x<=-1 or x>=n or y<=-1 or y>=n:
        return result, False
    if graph[x][y]==1:
        graph[x][y]=0
        dfs(x-1,y,k)
        dfs(x,y+1,k)
        dfs(x+1,y,k)
        dfs(x,y-1,k)
        result[k]+=1
        return result,True
    return result, False
k=0
for i in range(n):
    for j in range(n):
        result, b= dfs(i,j,k)
        if b ==True:
            answer+=1
            k+=1
            
print(answer) 
a=[]
for i in range(1000):
    if result[i] !=0:
        a.append(result[i])
    else:
        break
        
a.sort()
print(*a,sep ='\n')