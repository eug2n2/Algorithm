n,m = map(int,input().split())
a= list(map(int,input().split()))
start=0
end =max(a)
result =0
while (start<=end):
    mid = (start+end)//2
    deeok=0
    for i in range(n):
        if mid<a[i]:
            deeok+= a[i]-mid
    if deeok>=m:
        result =mid
        start = mid +1
    else:
        end = mid -1
    
print(result)

