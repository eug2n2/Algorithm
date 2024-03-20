#1463
m = int(input())
answer =[1e9]*(m+3)
answer[1]=0
answer[2] =1
answer[3]=1
if m>=4:
    for n in range(4,m+1):
        if n%3==0:
            answer[n] =min(answer[n],answer[n//3]+1)
        if n%2==0:
            answer[n] =min(answer[n],answer[n//2]+1)
        answer[n] =min(answer[n],answer[n-1]+1)
                
                
print(answer[m])    
