n=int(input()) # 색종이의 수
answer = 0 # 색종이의 넓이
confetti = [[0 for col in range(101)] for row in range(101)]
for _ in range(n):
    A,B=map(int,input().split()) # 색종이의 좌표
    for i in range(A, A+10):
        for j in range(B, B+10):
            confetti[i][j] = 1 
for i in range(101):
    for j in range(101):
        if confetti[i][j] == 1:
            answer += 1
print(answer) 
