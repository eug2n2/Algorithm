N= int(input())
import itertools
import math
count =0
for i in range(1,N//2+1):
    if i ==N/2:
        count+=2**i
    else:
        array=[]
        a= N -i*2
        for _ in range(a):
            array.append(a)
        for _ in range(1,i+1):
            array.append(1)
        nPr = math.perm(len(array), len(array)) 
        count+=nPr//math.factorial(a)//math.factorial(i)*(2**i)     
count+=1
print(round(count%10007))