def reverse(arr):
    sz=len(arr)
    toReturn=[None]*sz
    i=0
    n=2
    while i<sz:
        n=arr[sz-i-1]
        toReturn[i]=n
        i=i+1

    return toReturn

def printArray(arr):
    print(arr[0])
    i=0
    while i<len(arr):
        n=arr[i]
        print(" ")
        print(n)
        i=i+1

    print("")

def findMax(f):
    ofp_max=f[0]
    i=1
    while i<len(f):
        p=f[i]
        if p>ofp_max:
            ofp_max=p

        i=i+1

    return ofp_max

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
a=[None]*10
i=0
n=2
while i<len(a):
    a[i]=n
    n=2*n
    i=i+1

rev=reverse(a)
printArray(rev)
f=[9.3,8.8,17.5,1.0,2.1,3.2,4.4]
print(f[0])
ofp_max=findMax(f)
print(ofp_max)
selectionSort(f)
print(f[len(f)-1])
