n= int(input())
a =[0]*(n+1)
for i in range(1,n+1):
    a[i] = int(input())
ans=0

def maxcount(a):
    answer=[]
    for i in range(1,n+1):
        if a[i] == max(a):
            answer.append(i)
    return answer
    

while a[1] != max(a) or len(maxcount(a))!=1:
    i= a.index(max(a))
    if len(maxcount(a))!=1:
        answer=maxcount(a)
        i =answer[1]
    a[i]-=1
    ans+=1
    a[1]+=1
    
print(ans)
        