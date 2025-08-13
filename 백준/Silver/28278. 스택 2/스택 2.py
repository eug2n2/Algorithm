import sys

n = int(sys.stdin.readline())
stack = []
for i in range(n):
    p = sys.stdin.readline().split()
    if p[0] == '1':
        stack.append(int(p[1]))

    elif p[0] == '2':
        if stack:
            print(stack.pop())
        else:
            print(-1)

    elif p[0] == '3':
        print(len(stack))

    elif p[0] == '4':
        if stack:
            print(0)
        else:
            print(1)

    elif p[0] == '5':
        if stack:
            print(stack[-1])
        else:
            print(-1)