import sys

def find(a):
    global parent
    if parent[a] !=a:
        parent[a]= find(parent[a])
    return parent[a]
    
n= int(sys.stdin.readline()) # 컴퓨터의 수 
m= int(sys.stdin.readline()) # 연결되어있는 컴퓨터 쌍의 수 

answer = 0
parent = [0]*n
for i in range(n):
    parent[i]=i
for i in range(m):
    a,b = map(int, sys.stdin.readline().split())
    fa = find(a-1)
    fb = find(b-1)
    if(fa<=fb):
        parent[fb] = fa
    else:
        parent[fa] = fb

for i in range(1,n):
    if find(i) ==0:
        answer+=1
print(answer)            

