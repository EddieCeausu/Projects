from random import randint
import thread

def bubblesort(n):
    x = True
    while x:
        x = False
        for i in xrange(len(n) - 1):
            if n[i] > n[i + 1]:
                n[i], n[i + 1] = n[i + 1], n[i]
                x = True
    return n

def arraygen(n):
    array = []
    for i in range(n+1):
        j = randint(0, randint(0,n));
        array.append(j)
    return array

array = arraygen(100000)
print array,"\n"
array = bubblesort(array)
print array,"\n"
