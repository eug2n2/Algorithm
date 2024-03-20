#1546
import math
n =int(input())
item  = list(map(int,input().split()))
m =max(item)
for i in range(n) :
    item[i]= item[i]/m *100
    
a=math.fsum(item)/n
print(round(a, 6))