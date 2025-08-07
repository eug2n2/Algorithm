import sys
n, m = map(int, sys.stdin.readline().split())  # 듣도 못한 사람 수, 보도 못한 사람 수

noListen = set()

for _ in range(n):
    noListen.add(str(sys.stdin.readline().strip()))

noBoth = set()
for _ in range(m):
    name = str(sys.stdin.readline().strip())
    if name in noListen:
        noBoth.add(name)

print(len(noBoth))
for val in sorted(noBoth):
    print(val)
