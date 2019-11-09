def flip(b):
    if b:
        return False
    else:
        return True

def select(b,bb,bbb):
    return bbb

#
#  Program entry point - main 
#
b=True
bb=flip(b)
print(bb)
bbb=select(b,bb,b)
print(bbb)
