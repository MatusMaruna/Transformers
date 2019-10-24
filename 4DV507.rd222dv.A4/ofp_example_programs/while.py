def sumUpTo(n):
    i=1
    ofp_sum=0
    while i<n+1:
        ofp_sum=ofp_sum+i
        i=i+1

    return ofp_sum

#
#  Program entry point - main 
#
n=10
y=[None]*10
f=[9,8,17,11,12,13,14]
x=f[0+1]
print(x)
f[2]=2
x=f[2]
print(x)
print(f[3-1])
print(f)
res=sumUpTo(n)
print(res)
ff=[9.3,8.8,17.5,1.0,2.1,3.2,4.4]
print(ff[0])
