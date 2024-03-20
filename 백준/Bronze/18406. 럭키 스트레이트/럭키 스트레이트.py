#A07 럭키 스트레이트
k = input()  # 사용자로부터 띄어쓰기 없이 숫자를 입력받음
a = [int(i) for i in k]  #이거 안해도 됨
front =0
back=0
for i in range(len(a)//2):
    i=int(i)
    front +=a[i]
for i in range(len(a)//2,len(a)):
    back += a[i]
    
if front ==back:
    print("LUCKY")
else: 
    print("READY")