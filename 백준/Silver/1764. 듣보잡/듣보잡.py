n, m = map(int, input().split())  # 듣도 못한 사람 수, 보도 못한 사람 수

noListen = set()

for _ in range(n):
    name = input()
    noListen.add(name)

noBoth = set()
for _ in range(m):
    name = input()
    if name in noListen:
        noBoth.add(name) #듣보잡

print(len(noBoth))
for val in sorted(noBoth):
    print(val)
