#9012
def correct(b):
    test=b
    si=0
    while True:
        if len(test)==0:
            return True
            break
        elif test[0]==")" or si == len(test)-1:
            return False
            break
        elif test[si] == "(" and test[si+1] ==")":
            test.pop(si)
            test.pop(si)
            si=0
        else:
            si +=1
       
def check(a):
    start =0
    i= 1
    while start < len(a)-1 and i <= len(a)-1 :
        b=a[start:i+1]
        if b.count("(")!=b.count(")") or b[-1]=="(":  
            i+=2    
            continue
        elif correct(b):
            start = i+1
            i+=2
        else:
            return False
            break
    return True
         
n=int(input())
for i in range(n):
    a =list(input())
    if len(a)%2==1 or a[0]==")" or a[-1]=="(" or a.count("(")!=a.count(")") :
        print("NO")
    elif not check(a):
        print("NO")
    else:
        print("YES")