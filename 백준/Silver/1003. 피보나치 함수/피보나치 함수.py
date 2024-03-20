answer =[[0,0,0] for _ in range(41)]

answer[0]=[0,1,0]
answer[1]=[1,0,1]
for n in range(2,41):
    answer[n] = [answer[n-1][i] + answer[n-2][i] for i in range(3)]

t=int(input())
for i in range(t):
    n=int(input())
    print(answer[n][1] ,answer[n][2] )