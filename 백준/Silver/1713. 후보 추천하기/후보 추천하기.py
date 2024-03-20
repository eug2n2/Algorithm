n =int(input())
recommend=int(input())
a=list(map(int,input().split()))
p=[0]*n
b=[0]*n

def mincount(a):
    answer=[]
    for i in range(n):
        if a[i] == min(a):
            answer.append(i)
    answer.sort()
    return answer
    
for i in a:
    if i not in b and 0 in b:
        b[b.index(0)]=i
        p[b.index(i)]=1
    elif i in b:
        p[b.index(i)]+=1
    elif i not in b :
        hubo=mincount(p)
        b.pop(hubo[0])
        p.pop(hubo[0])
        b.append(i)
        p.append(1)
        
b.sort()
while 0 in b:
    b.remove(0)
    
print(*b)