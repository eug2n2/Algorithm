import sys
word = sys.stdin.readline().strip().upper()

count = [0] * 26
for char in word:
    if 'A' <= char <= 'Z':
        count[ord(char) - ord('A')] += 1    

max_count = max(count)

if count.count(max_count) > 1: # 가장 많이 사용된 알파벳이 여러 개 존재하는 경우
    print("?")
else:
    print(chr(count.index(max_count) + ord('A')))
