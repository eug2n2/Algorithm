from heapq import *

n, m = map(int, input().split())
indegree = [0] * (n+1)
graph = [[] for _ in range(n+1)]
for _ in range(m):
    a, b = map(int, input().split())
    indegree[b] += 1
    graph[a].append(b)

heap = []
for i in range(1, n+1):
    if indegree[i] == 0:
        heappush(heap, i)
result = []
while heap:
    now = heappop(heap)
    result.append(now)
    for i in graph[now]:
        indegree[i] -= 1
        if indegree[i] == 0:
            heappush(heap, i)
print(*result)