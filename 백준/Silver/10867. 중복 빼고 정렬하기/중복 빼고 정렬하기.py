import sys

n = int(sys.stdin.readline())
numbers = list(map(int, sys.stdin.readline().split()))

Set = set(numbers)  

for val in sorted(Set):
    print(val, end=" ")
