def maxOfTwo(a,b):
    if a>b:
        return a
    else:
        return b

def maxOfThree(a,b,c):
    if a>b:
        if a>c:
            return a
        elif c>a:
            return c
        else:
            return c
    else:
        if b>c:
            return b
        elif c>b:
            return c
        else:
            return c


def sumUpTo(n):
    i=1
    ofp_sum=0
    while i<n+1:
        ofp_sum=ofp_sum+i
        i=i+1

    return ofp_sum

def retTru()):
    return False

#
#  Program entry point - main 
#
p=3
q=7
res=maxOfTwo(p,q)
print(res)
res=maxOfThree(p,q,9)
print(res)
