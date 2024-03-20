import sys
input = sys.stdin.readline
n =int(input())
anss=input()
total=0
a=set()
for i in range(n-1):
    bo=input().strip()
    if bo=="ENTER":
        total+=len(a)
        a=set()
    else:        
        a.add(bo)
total+=len(a)
print(total)

