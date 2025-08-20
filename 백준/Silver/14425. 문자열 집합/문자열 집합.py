import sys

n, m = map(int, sys.stdin.readline().split())
answer = 0
s = set()
for i in range(n):
    s.add(sys.stdin.readline())
for i in range(m):
    v= sys.stdin.readline()
    if v in s:
        answer += 1
        
print(answer)            