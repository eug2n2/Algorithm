t=int(input())
for i in range(t):
    n= int(input())
    parent=[0]*(n+1)
    for i in range(n-1):
        a,b = map(int,input().split())
        parent[b]=a
    n,m = map(int,input().split())
    n_parent,m_parent=[0,n],[0,m]
    i=1
    while parent[n]:
        n_parent.append(parent[n])
        n=parent[n]
    while parent[m]:
        m_parent.append(parent[m])
        m=parent[m]
    while n_parent[-i]==m_parent[-i]:
        i+=1
    print(m_parent[-i+1])
    
    
        