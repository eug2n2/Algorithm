T=int(input())
for _ in range(T):
    A,B=map(int,input().split())
    A=A%10
    if(A==0):
        print("10")
    elif A == 1 or A == 5 or A == 6:
        print(A)
    elif A ==4 :
        if B % 2 == 0:
            print(6)
        else:
            print(4)
    elif A == 9:
        if B % 2 == 0:
            print(1)
        else:
            print(9)
    elif A == 2:
        if B % 4 == 0:
            print(6)
        elif B % 4 == 1:
            print(2)
        elif B % 4 == 2:
            print(4)
        else:
            print(8)
    elif A == 3:
        if B % 4 == 0:
            print(1)
        elif B % 4 == 1:
            print(3)
        elif B % 4 == 2:
            print(9)
        else:
            print(7)
    elif A == 7:
        if B % 4 == 0:
            print(1)
        elif B % 4 == 1:
            print(7)
        elif B % 4 == 2:
            print(9)
        else:
            print(3)
    else:  # A == 8
        if B % 4 == 0:   
            print(6)
        elif B % 4 == 1:  
            print(8)      
        elif B % 4 == 2:
            print(4)
        else:
            print(2)
# 0: 10     
# 1: 1 
# 5: 5
# 6: 6
# 4: 4 6
# 9: 9 1
# 2: 2 4 8 6 
# 3: 3 9 7 1
# 7: 7 9 3 1
# 8: 8 4 2 6
