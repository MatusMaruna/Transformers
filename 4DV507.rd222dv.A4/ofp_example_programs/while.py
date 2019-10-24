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
f=[9,8,17,11,12,13,14]
x=f[0]
print(f)
res=sumUpTo(n)
print(res)
