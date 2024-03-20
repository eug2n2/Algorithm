n=int(input())
ndata =list(map(int,input().split()))
ndata.sort()
def binarys(target,ndata):
    start =0
    end = n-1
    while start <=end:
        mid=(start+end)//2
        if target ==ndata[mid]:
            end =mid-1
        elif target > ndata[mid]:
            start = mid+1
        else:
            end =mid-1
    return start
def binarye(target,ndata):
    start =0
    end = n-1
    while start <=end:
        mid=(start+end)//2
        if target >=ndata[mid]:
            start = mid+1
        else:
            end =mid-1
    return end


m =int(input())
mdata =list(map(int,input().split()))
for i in range(m):
    answer=binarye(mdata[i],ndata)-binarys(mdata[i],ndata)+1
    print(answer,end=' ')