import sys
import math
n = int(sys.stdin.readline())
array = list(map(int, sys.stdin.readline().split()))

# 최소공배수
lcm= array[0]
for i in range(1,n):
    lcm = math.lcm(lcm, array[i])
    
lcm*=2
print(lcm)