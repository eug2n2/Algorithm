#12852
x = int(input())
answer =[[i]for i in range(x+1)]
d = [0] * (x+1)
def pusth(answer,i,k):
    for j in range(len(answer[k])):
        answer[i].append(answer[k][j])
    return answer
for i in range(2, x+1):
    d[i] = d[i-1] + 1
    if i % 3 == 0:
        d[i] = min(d[i], d[i//3]+1)
    if i % 2 == 0:
        d[i] = min(d[i], d[i//2]+1)
    if i % 3 == 0 and d[i]==d[i//3]+1:
        answer=pusth(answer,i,i//3)
    elif i % 2 == 0 and d[i]==d[i//2]+1:
        answer=pusth(answer,i,i//2)
    else:
        answer=pusth(answer,i,i-1)
    
print(d[x])
for i in range(len(answer[x])):
    print(answer[x][i],end=' ')