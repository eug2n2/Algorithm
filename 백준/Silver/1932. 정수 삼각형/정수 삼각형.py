n= int(input())
tri=[]
for i in range(n):
    tri.append(list(map(int,input().split())))
d= [[-1]*(i+1) for i in range (n)]
d[0][0] = tri[0][0]
for i in range (0,n-1):
    for j in range(i+1):
        if d[i][j] !=-1:
            d[i+1][j]= max(tri[i+1][j]+d[i][j],d[i+1][j])
            d[i+1][j+1]= max(tri[i+1][j+1]+d[i][j],d[i+1][j+1])
result =0
for i in range(n):
    result = max(result,d[n-1][i])
print(result)