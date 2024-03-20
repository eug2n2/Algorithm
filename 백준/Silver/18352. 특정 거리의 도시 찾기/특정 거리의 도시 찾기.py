#18352
n,m,k,x =map(int,input().split())
graph=[[]for i in range(n+1)]
for i in range(m):
    a,b =map(int,input().split())
    graph[a].append(b)
visited=[False]*(n+1)
answer=[1e9]*(n+1)
from collections import deque

def bfs(graph,start,visited):
    queue=deque([start])
    visited[x]=True
    a=0
    while queue:
        v= queue.popleft()
        a+=1
        for i in graph[v]:
            if not visited[i]:
                queue.append(i)
                visited[i]=True
                answer[i]= min(a,answer[v]+1)
    return answer
answer=bfs(graph,x,visited)
    
if answer.count(k)==0:
    print(-1)
else: 
    for i in range(n+1):
        if answer[i] ==k:
            print(i)