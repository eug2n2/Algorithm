# 문자열 뒤집기 
k =input()
a =[int(i) for i in k]
result1=[]
result=[]
for i in range (len(a)):
    if a[i] ==1:
        result1.append(i)
if len(result1)==0:
    answer1=0
else:
    answer1=1
    for i in range(len(result1)-1):
        if result1[i+1] - result1[i] !=1:
            answer1 += 1

for i in range (len(a)):
    if a[i] ==0:
        result.append(i)
if len(result)==0:
    answer2=0
else:
    answer2=1
    for i in range(len(result)-1):
        if result[i+1] - result[i] !=1:
            answer2 += 1
print(min(answer1,answer2))   