import sys

hmin, hmax = map(int, sys.stdin.readline().split())
smin, smax = map(int, sys.stdin.readline().split())
vmin, vmax= map(int, sys.stdin.readline().split())
r,g,b =map(int, sys.stdin.readline().split())
M= max(r,g,b)
m= min(r,g,b)
v= M
s= 255*(v-m)/v
h=0
if v==r:
   h= 60*(g-b)/(v-m)
elif v==g:
    h = 120+ 60*(b-r)/(v-m)
else:
    h= 240 + 60*(r-g)/(v-m)
if h<0:
    h+=360
if not (hmin <= h <= hmax):
    print("Lumi will not like it.")
elif not (smin<= s<=smax):
    print("Lumi will not like it.")
elif not (vmin<= v <=vmax):
     print("Lumi will not like it.")
else :
     print("Lumi will like it.")