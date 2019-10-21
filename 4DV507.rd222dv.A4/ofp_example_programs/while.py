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
res=sumUpTo(n)
print(res)
print(2, end=" ")
