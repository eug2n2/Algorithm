#국영수 A23
N =int(input())
data=[]
for i in range(N):
    input_data = input().split()
    data.append((input_data[0],int(input_data[1]),int(input_data[2]),int(input_data[3])))
data =sorted(data,key =lambda x: (-x[1],x[2],-x[3],x[0]))

for i in range(N):
    print(data[i][0])
    