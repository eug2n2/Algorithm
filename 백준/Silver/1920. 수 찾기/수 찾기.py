# 1920
def binary_search (n,nlist, target):
    start =0
    end= n-1
    while start <=end:
        mid =(start+end)//2
        if nlist[mid] ==target:
            return True
            break
        elif nlist[mid]> target:
            end = mid -1
        else: 
            start = mid+1
    return False
        
n =int(input())
nlist =list(map(int,input().split())) 
nlist.sort()

m =int(input())
item =list(map(int,input().split())) 
for i in range(m):
    if binary_search(n,nlist,item[i]):
        print(1)
    else:
        print(0)
    