from collections import Counter
n=int(input())
data=[]
for i in range(n):
    data.append(int(input()))
print(round(sum(data)/n))
data.sort()
if n%2==0:
    print((data[(n-1)//2]+data[(n-1)//2+1])/2)
else:
    print(data[(n-1)//2])
def bindo(data): #x가 list로 주어질 때, 그 수 중에서 최빈값을 구할 것
    dictionary = {}
    for i in data:
        if dictionary.get(i) is None: #파이썬에선 없음을 None으로 표기
            dictionary[i] = 1 #i라는 숫자가 나올때 1을 삽입
        else:
            dictionary[i] += 1 #i라는 숫자의 빈도 증가
    #여러개의 최빈값을 뽑아내기
    most = max(dictionary.values()) #최빈값 추출 - 값중에 최대값 찾기
    max_list ={}
    #최빈값 dictionary만들기
    for key, value in dictionary.items():
        if value == most :
            max_list[key] = value #최빈값 리스트만 추출
    return max_list

final= bindo(data)
final =list(final.keys())
if len(final)==1:
    print(*final)
else:
    print(final[1])

print(max(data)-min(data))