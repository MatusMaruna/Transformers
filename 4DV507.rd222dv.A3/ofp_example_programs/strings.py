def countA(ofp_str):
    n=0
    i=0
    while i<len(ofp_str):
        c=ofp_str[i]
        if c=='A':
            n=n+1

        i=i+1

    return n

def replace(ofp_str,oldChar,newChar):
    i=0
    while i<len(ofp_str):
        c=ofp_str[i]
        if c==oldChar:
            ofp_str[i]=newChar

        i=i+1

    return ofp_str

def printArray(arr):
    print(arr[0])
    i=0
    while i<len(arr):
        c=arr[i]
        print(" ")
        print(c)
        i=i+1

    print("")

def containsXandY(ofp_str):
    if contains(ofp_str,'X'):
        if contains(ofp_str,'Y'):
            return True


    return False

def contains(ofp_str,ch):
    i=0
    while i<len(ofp_str):
        p=ofp_str[i]
        if p==ch:
            return True

        i=i+1

    return False

#
#  Program entry point - main 
#
s="All students got the highest grade A!"
res=countA(s)
print(res)
charArr=['a','b','c','d','e','f']
charArr=replace(charArr,'b','B')
printArray(charArr)
xy="Xerxes said Yes!"
ok=containsXandY(xy)
print(ok)
