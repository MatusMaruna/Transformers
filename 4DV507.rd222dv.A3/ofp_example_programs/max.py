def maxOfTwo(a,b):
    if a>b:
        return a
    else:
        return b

def maxOfThree(a,b,c):
    if a>b:
        if a>c:
            return a
        else:
            if c>a:
                return c
            else:
                return c
    else:
        if b>c:
            return b
        else:
            if c>b:
                return c
            else:
                return c


#
#  Program entry point - main 
#
p=3
q=7
res=maxOfTwo(p,q)
print(res)
res=maxOfThree(p,q,9)
print(res)
