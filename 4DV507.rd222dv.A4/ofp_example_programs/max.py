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


def selectionSort(arr):
    i=0
    while i<len(arr)-1:
        smallest=i
        j=i+1
        while j<len(arr):
            if arr[j]<arr[smallest]:
                smallest=j

            j=j+1

        smallestNumber=arr[smallest]
        arr[smallest]=arr[i]
        arr[i]=smallestNumber
        i=i+1


#
#  Program entry point - main 
#
p=3
q=7
res=maxOfTwo(p,q)
print(res)
res=maxOfThree(p,q,9)
print(res)
