def containsXandY(ofp_str):
    if contains(ofp_str,'X'):
        if contains(ofp_str,'Y'):
            return True


    return False

def printArray(arr):
    print(arr[0], end=" ")
    i=0
    while i<len(arr):
        c=arr[i]
        print(" ", end=" ")
        print(c, end=" ")
        i=i+1

    print("")

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
charArr=['a','b','c','d','e','f']
printArray(c)
