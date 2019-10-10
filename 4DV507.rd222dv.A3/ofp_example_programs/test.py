def reverse(arr):
    # Test in method
    sz=arr.length
    toReturn=[sz]
    i=0
    n=2
    while i<sz:
        # Test in method
        n=arr[sz-i-1]
        toReturn[i]=n
        i=i+1

    return toReturn

def printArray(arr):
    # Test in method
    print(arr[0])

    i=0
    while i<arr.length:
        # Test in method
        n=arr[i]
        print(" ")

        print(n)

        i=i+1

    print("")


def findMax(f):
    # Test in method
    ofp_max=f[0]
    i=1
    while i<f.length:
        # Test in method
        p=f[i]
        if p>max:
            # Test in method
            ofp_max=p

        i=i+1

    return max

def selectionSort(arr):
    # Test in method
    i=0
    while i<arr.length-1:
        # Test in method
        smallest=i
        j=i+1
        while j<arr.length:
            # Test in method
            if arr[j]<arr[smallest]:
                # Test in method
                smallest=j

            j=j+1

        smallestNumber=arr[smallest]
        arr[smallest]=arr[i]
        arr[i]=smallestNumber
        i=i+1


#
#  Program entry point - main 
#
# Test in method
a=[10]
i=0
n=2
while i<a.length:
    # Test in method
    a[i]=n
    n=2*n
    i=i+1

rev=reverse(a)
null
f=null
print(f[0])

ofp_max=findMax(f)
print(max)

null
print(f[f.length-1])

