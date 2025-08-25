import sys
import math

N, M, K = map(int, sys.stdin.readline().split())

total = math.comb(N, M) 

# 당첨되는 경우의 수 계산
win = 0
for i in range(K, M + 1):
    win += math.comb(M, i) * math.comb(N-M, M-i) 

probability = win / total
print(probability)
