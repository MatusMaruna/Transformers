def maxOfTwo(a,b):
    # Test in method
    if a>b:
        return a
    else:
        return b

def maxOfThree(a,b,c):
    # Test in method
    if a>b:
        # Test in method
        if a>c:
            return a
        else:
            if c>a:
                return c
            else:
                return c
    else:
        # Test in method
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
# Test in method
p=3
q=7
res=maxOfTwo(p,q)
print(res)
res=maxOfThree(p,q,9)
print(res)
