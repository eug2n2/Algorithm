val = 0
n=1
m=1
for i in range(9):
    row = list(map(int, input().split()))
    for j in range(9):
        if row[j] > val:
            val = row[j]
            n = i + 1
            m = j + 1

print(val)
print(n, m)