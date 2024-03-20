N= int(input())
A= list(map(int,input().split()))


cal= list(map(int,input().split()))
dataset=[]
for i in range(cal[0]):
    dataset.append("+")
for i in range(cal[1]):
    dataset.append("-")
for i in range(cal[2]):
    dataset.append("*")
for i in range(cal[3]):
    dataset.append("//")
    
def calculation(A,res):
    answer =[]
    for j in range(len(res)):
        result= A[0]
        for i in range(N-1):
            y= A[i+1]
            if res[j][i] =="*":
                result=result*y
            elif res[j][i]=="+":
                result=result+y
            elif res[j][i] =="-":
                result=result-y
            elif res[j][i] =="//":
                if result*A[1]>=0:
                    result=result//y
                else:
                    result= -(abs(result)//abs(y))

        answer.append(result)
        
    return answer

m= -1e10
n = 1e10
from itertools import permutations
# 2개를 뽑아 일렬로 나열하는 경우의 수(단, 중복 허용)
if N==2:
    if dataset[0] =="*":
        result=A[0]*A[1]
    elif dataset[0]=="+":
        result=A[0]+A[1]
    elif dataset[0] =="-":
        result=A[0]-A[1]
    elif dataset[0] =="//":
        if A[0]*A[1]>=0:
            result=A[0]//A[1]
        else:
            result= -(abs(A[0])//abs(A[1]))
    print(result)
    print(result)
else:
    res = list(permutations(dataset, N-1))
    a=calculation(A,res)
    m= max(a)
    n= min(a)
    print(m)
    print(n)
