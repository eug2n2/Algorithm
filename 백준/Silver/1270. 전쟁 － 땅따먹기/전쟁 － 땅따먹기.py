import sys
from collections import Counter

n = int(sys.stdin.readline().strip())

for _ in range(n):
    arr = list(map(int, sys.stdin.readline().strip().split()))
    counts= Counter(arr[1:])
    most_common = counts.most_common()
    max_count = most_common[0][1]
    if(max_count > arr[0]//2):
        print(most_common[0][0])
    else:
        print("SYJKGW")